package uy.infocorp.banking.glass.view.benefit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.location.Location;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.controller.benefit.OrientationManager;
import uy.infocorp.banking.glass.model.benefit.Benefit;
import uy.infocorp.banking.glass.util.math.MathUtils;

public class BenefitsCompassView extends View {

    private static final float TICK_WIDTH = 2;
    private static final float TICK_HEIGHT = 10;
    private static final float DIRECTION_TEXT_HEIGHT = 40.0f;

    private static final float PLACE_TEXT_HEIGHT = 50.0f;
    private static final float PLACE_DISTANCE_TEXT_HEIGHT = 30.0f;

    private static final float PLACE_PIN_WIDTH = 50.0f;
    private static final float PLACE_TEXT_LEADING = 4.0f;
    private static final float PLACE_TEXT_MARGIN = 10.0f;

    private static final float MIN_DISTANCE_TO_ANIMATE = 15.0f;

    // Direction that the user is facing
    private float heading;

    // Direction currently displayed
    private float animatedHeading;

    private Context context;
    private OrientationManager orientationManager;
    private List<Benefit> nearbyBenefits;
    private Benefit frontBenefit;

    private final Paint paint;
    private final Paint tickPaint;
    private final TextPaint benefitDistancePaint;
    private final TextPaint benefitPaint;
    private final Rect textBounds;
    private final List<Rect> allBounds;
    private final NumberFormat distanceFormat;
    private final String[] directions;
    private final ValueAnimator valueAnimator;

    public BenefitsCompassView(Context context) {
        this(context, null, 0);
    }

    public BenefitsCompassView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BenefitsCompassView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        this.context = context;

        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
        this.paint.setTextSize(DIRECTION_TEXT_HEIGHT);
        this.paint.setColor(Color.GRAY);
        this.paint.setTypeface(Typeface.create("sans-serif-thin", Typeface.BOLD));

        this.tickPaint = new Paint();
        this.tickPaint.setStyle(Paint.Style.STROKE);
        this.tickPaint.setStrokeWidth(TICK_WIDTH);
        this.tickPaint.setAntiAlias(true);
        this.tickPaint.setColor(Color.GRAY);

        this.benefitDistancePaint = new TextPaint();
        this.benefitDistancePaint.setStyle(Paint.Style.FILL);
        this.benefitDistancePaint.setAntiAlias(true);
        this.benefitDistancePaint.setColor(Color.GRAY);
        this.benefitDistancePaint.setTextSize(PLACE_DISTANCE_TEXT_HEIGHT);
        this.benefitDistancePaint.setTypeface(Typeface.create("sans-serif-light", Typeface.BOLD));

        this.benefitPaint = new TextPaint();
        this.benefitPaint.setStyle(Paint.Style.FILL);
        this.benefitPaint.setAntiAlias(true);
        this.benefitPaint.setColor(Color.WHITE);
        this.benefitPaint.setTextSize(PLACE_TEXT_HEIGHT);
        this.benefitPaint.setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL));

        this.textBounds = new Rect();
        this.allBounds = Lists.newArrayList();

        this.distanceFormat = NumberFormat.getNumberInstance();
        this.distanceFormat.setMinimumFractionDigits(0);
        this.distanceFormat.setMaximumFractionDigits(1);

        // We use NaN to indicate that the compass is being drawn for the first
        // time, so that we can jump directly to the starting orientation
        // instead of spinning from a default value of 0.
        this.animatedHeading = Float.NaN;

        this.directions = context.getResources().getStringArray(R.array.direction_abbreviations);

        this.valueAnimator = new ValueAnimator();
        setupAnimator();
    }

    public Benefit getFrontBenefit() {
        return this.frontBenefit;
    }

    public void setOrientationManager(OrientationManager orientationManager) {
        this.orientationManager = orientationManager;
    }

    public float getHeading() {
        return this.heading;
    }

    public void setHeading(float degrees) {
        this.heading = MathUtils.mod(degrees, 360.0f);
        animateTo(this.heading);
    }

    public void setNearbyPlaces(List<Benefit> benefits) {
        this.nearbyBenefits = benefits;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // The view displays 90 degrees across its width so that one 90 degree head rotation is
        // equal to one full view cycle.
        float pixelsPerDegree = getWidth() / 90.0f;
        float centerX = getWidth() / 2.0f;
        float centerY = getHeight() / 2.0f;

        canvas.save();
        canvas.translate(-animatedHeading * pixelsPerDegree + centerX, centerY);

        // In order to ensure that places on a boundary close to 0 or 360 get drawn correctly, we
        // draw them three times; once to the left, once at the "true" bearing, and once to the
        // right.
        for (int i = -1; i <= 1; i++) {
            drawPlaces(canvas, pixelsPerDegree, i * pixelsPerDegree * 360);
        }

        drawCompassDirections(canvas, pixelsPerDegree);

        canvas.restore();
    }

    // Draws the compass direction strings (N, NW, W, etc.).
    private void drawCompassDirections(Canvas canvas, float pixelsPerDegree) {
        float degreesPerTick = 360.0f / directions.length;

        // We draw two extra ticks/labels on each side of the view so that the
        // full range is visible even when the heading is approximately 0.
        for (int i = -2; i <= directions.length + 2; i++) {
            if (MathUtils.mod(i, 2) == 0) {
                // Draw a text label for the even indices.
                String direction = directions[MathUtils.mod(i, directions.length)];
                paint.getTextBounds(direction, 0, direction.length(), textBounds);

                canvas.drawText(direction,
                        i * degreesPerTick * pixelsPerDegree - textBounds.width() / 2,
                        textBounds.height() / 2, paint);
            } else {
                // Draw a tick mark for the odd indices.
                canvas.drawLine(i * degreesPerTick * pixelsPerDegree, -TICK_HEIGHT / 2, i
                        * degreesPerTick * pixelsPerDegree, TICK_HEIGHT / 2, tickPaint);
            }
        }
    }

    // Draws the pins and text labels for the nearby list of places.
    private void drawPlaces(Canvas canvas, float pixelsPerDegree, float offset) {
        if (orientationManager.hasLocation() && nearbyBenefits != null) {
            synchronized (nearbyBenefits) {
                Location userLocation = orientationManager.getLocation();

                this.allBounds.clear();

                // Loop over the list of nearby places (those within 10 km of the user's current
                // location), and compute the relative bearing from the user's location to the
                // place's location. This determines the position on the compass view where the
                // pin will be drawn.
                Benefit front = this.nearbyBenefits.get(0);
                double smallestDifference = 360;
                for (Benefit benefit : this.nearbyBenefits) {
                    float bearing = bearing(userLocation, benefit);

                    String name = StringUtils.abbreviate(benefit.getName(), 15);
                    Bitmap benefitType = BitmapFactory.decodeResource(context.getResources(), benefit.getIconId());
                    double distanceKm = distance(userLocation, benefit);
                    String distance = "(" + distanceFormat.format(distanceKm) + " km)";

                    // Measure the text and offset the text bounds to the location where the text
                    // will finally be drawn.
                    Rect textBounds = new Rect();
                    this.benefitPaint.getTextBounds(name + distance, 0, name.length() + distance.length(), textBounds);
                    textBounds.offsetTo((int) (offset + bearing * pixelsPerDegree
                            + PLACE_PIN_WIDTH / 2 + PLACE_TEXT_MARGIN), canvas.getHeight() / 2
                            - (int) PLACE_TEXT_HEIGHT + (int) (distanceKm * 5.0));

                    // Extend the bounds rectangle to include the pin icon and a small margin
                    // to the right of the text, for the overlap calculations below.
                    textBounds.left -= PLACE_PIN_WIDTH + PLACE_TEXT_MARGIN;
                    textBounds.right += PLACE_TEXT_MARGIN;

                    // Only draw the benefits that do not intersect any previously drawn one
                    if (!intersects(textBounds)) {
                        allBounds.add(textBounds);

                        float x = offset + bearing * pixelsPerDegree + PLACE_PIN_WIDTH / 2
                                + PLACE_TEXT_MARGIN;
                        float y = textBounds.top + PLACE_TEXT_HEIGHT;

                        canvas.drawBitmap(benefitType, offset + bearing * pixelsPerDegree
                                - PLACE_PIN_WIDTH / 2, textBounds.top + 2, paint);
                        canvas.drawText(name, x, y, benefitPaint);
                        canvas.drawText(distance, x + name.length() * 25, y, benefitDistancePaint);

                        // Update front benefit
                        double difference = MathUtils.getAngleDifference(bearing, this.heading);
                        if (difference < smallestDifference) {
                            smallestDifference = difference;
                            front = benefit;
                        }
                    }
                }
                this.frontBenefit = front;
            }
        }
    }

    private float distance(Location userLocation, Benefit benefit) {
        double userLatitude = userLocation.getLatitude();
        double userLongitude = userLocation.getLongitude();

        double benefitLatitude = benefit.getLatitude();
        double benefitLongitude = benefit.getLongitude();

        return MathUtils.getDistance(userLatitude, userLongitude, benefitLatitude, benefitLongitude);
    }

    private float bearing(Location userLocation, Benefit benefit) {
        double userLatitude = userLocation.getLatitude();
        double userLongitude = userLocation.getLongitude();

        double benefitLatitude = benefit.getLatitude();
        double benefitLongitude = benefit.getLongitude();

        return MathUtils.getBearing(userLatitude, userLongitude, benefitLatitude, benefitLongitude);
    }

    // Returns true if there is another benefit drawn on there
    private boolean intersects(Rect textBounds) {
        textBounds.offset(0, (int) -(PLACE_TEXT_HEIGHT + PLACE_TEXT_LEADING));

        for (Rect existing : this.allBounds) {
            if (Rect.intersects(existing, textBounds)) {
                return true;
            }
        }

        return false;
    }

    private void setupAnimator() {
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(250);

        // Notifies us at each frame of the animation so we can redraw the view.
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                animatedHeading = MathUtils.mod((Float) valueAnimator.getAnimatedValue(), 360.0f);
                invalidate();
            }
        });

        // Notifies us when the animation is over. During an animation, the user's head may have
        // continued to move to a different orientation than the original destination angle of the
        // animation. Since we can't easily change the animation goal while it is running, we call
        // animateTo() again, which will either redraw at the new orientation (if the difference is
        // small enough), or start another animation to the new heading. This seems to produce
        // fluid results.
        valueAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animator) {
                animateTo(heading);
            }
        });
    }

    /*
     * Animates the view to the specified heading, or simply redraws it immediately if the
     * difference between the current heading and new heading are small enough that it wouldn't be
     * noticeable.
     */
    private void animateTo(float end) {
        // Only act if the animator is not currently running. If the user's orientation changes
        // while the animator is running, we wait until the end of the animation to update the
        // display again, to prevent jerkiness.
        if (!valueAnimator.isRunning()) {
            float start = animatedHeading;
            float distance = Math.abs(end - start);
            float reverseDistance = 360.0f - distance;
            float shortest = Math.min(distance, reverseDistance);

            if (Float.isNaN(animatedHeading) || shortest < MIN_DISTANCE_TO_ANIMATE) {
                // If the distance to the destination angle is small enough (or if this is the
                // first time the compass is being displayed), it will be more fluid to just redraw
                // immediately instead of doing an animation.
                animatedHeading = end;
                invalidate();
            } else {
                // For larger distances (i.e., if the compass "jumps" because of sensor calibration
                // issues), we animate the effect to provide a more fluid user experience. The
                // calculation below finds the shortest distance between the two angles, which may
                // involve crossing 0/360 degrees.
                float goal;

                if (distance < reverseDistance) {
                    goal = end;
                } else if (end < start) {
                    goal = end + 360.0f;
                } else {
                    goal = end - 360.0f;
                }

                valueAnimator.setFloatValues(start, goal);
                valueAnimator.start();
            }
        }
    }
}
