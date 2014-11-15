package uy.infocorp.banking.glass.controller.benefit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.location.Location;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.glass.timeline.DirectRenderingCallback;
import com.google.android.glass.widget.CardBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.model.benefit.Benefit;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.view.dialog.GlassDialog;
import uy.infocorp.banking.glass.view.benefit.BenefitsCompassView;

public class BenefitsCompassRenderer implements DirectRenderingCallback {

    private static final String TAG = BenefitsCompassRenderer.class.getSimpleName();

    private static final float TOO_STEEP_PITCH_DEGREES = 50.0f;
    private static final int REFRESH_RATE_FPS = 45;
    private static final long FRAME_TIME_MILLIS = TimeUnit.SECONDS.toMillis(1) / REFRESH_RATE_FPS;

    private Bitmap syncIcon;

    private BenefitsService service;
    private final TextView benefitNameView;

    private final TextView benefitDescriptionView;
    private SurfaceHolder surfaceHolder;
    private RenderThread renderThread;
    private boolean isTooSteep;
    private boolean hasMagneticInterference;
    private int surfaceWidth;

    private int surfaceHeight;
    private boolean renderingPaused;

    private boolean serviceCalled;
    private final FrameLayout frameLayout;
    private final BenefitsCompassView benefitsCompassView;
    private final RelativeLayout tipsContainer;
    private final RelativeLayout benefitsContainer;
    private final TextView tipsView;

    private final OrientationManager orientationManager;
    private final BenefitsCompassListener benefitsCompassListener = new BenefitsCompassListener() {

        @Override
        public void onOrientationChanged(OrientationManager orientationManager) {
            benefitsCompassView.setHeading(orientationManager.getHeading());

            boolean oldTooSteep = isTooSteep;
            isTooSteep = (Math.abs(orientationManager.getPitch()) > TOO_STEEP_PITCH_DEGREES);
            if (isTooSteep != oldTooSteep) {
                updateTipsView();
            }
        }

        @Override
        public void onLocationChanged(OrientationManager orientationManager) {
            updateNearBenefits();
        }

        @Override
        public void onAccuracyChanged(OrientationManager orientationManager) {
            hasMagneticInterference = orientationManager.hasInterference();
            updateTipsView();
        }
    };

    public BenefitsCompassRenderer(BenefitsService service, OrientationManager orientationManager) {
        LayoutInflater inflater = LayoutInflater.from(service);
        this.service = service;
        this.frameLayout = (FrameLayout) inflater.inflate(R.layout.benefits, null);
        this.frameLayout.setWillNotDraw(false);

        this.syncIcon = BitmapFactory.decodeResource(service.getResources(), R.drawable.ic_sync);

        this.benefitsCompassView = (BenefitsCompassView) this.frameLayout.findViewById(R.id.compass);
        this.tipsContainer = (RelativeLayout) this.frameLayout.findViewById(R.id.tips_container);
        this.benefitsContainer = (RelativeLayout) this.frameLayout.findViewById(R.id.benefit_container);
        this.tipsView = (TextView) this.frameLayout.findViewById(R.id.tips_view);
        this.benefitNameView = (TextView) this.frameLayout.findViewById(R.id.benefits_name);
        this.benefitDescriptionView = (TextView) this.frameLayout.findViewById(R.id.benefits_description);

        this.orientationManager = orientationManager;

        this.benefitsCompassView.setOrientationManager(this.orientationManager);
        this.orientationManager.setBenefitsCompassListener(this.benefitsCompassListener);

        this.serviceCalled = false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        surfaceWidth = width;
        surfaceHeight = height;
        doLayout();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        renderingPaused = false;
        surfaceHolder = holder;
        updateRenderingState();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        surfaceHolder = null;
        updateRenderingState();
    }

    @Override
    public void renderingPaused(SurfaceHolder holder, boolean paused) {
        renderingPaused = paused;
        updateRenderingState();
    }

    public Benefit getFrontBenefit() {
        return this.benefitsCompassView.getFrontBenefit();
    }

    private void updateRenderingState() {
        boolean shouldRender = (this.surfaceHolder != null) && !this.renderingPaused;
        boolean isRendering = (this.renderThread != null);

        if (shouldRender != isRendering) {
            if (shouldRender) {
                this.orientationManager.start();

                if (this.orientationManager.hasLocation()) {
                    updateNearBenefits();
                }

                this.renderThread = new RenderThread();
                this.renderThread.start();
            } else {
                this.renderThread.quit();
                this.renderThread = null;

                this.orientationManager.stop();
            }
        }
    }

    private void updateNearBenefits() {
        Location location = this.orientationManager.getLocation();

        new GetNearbyBenefitsTask(new FinishedTaskListener<List<Benefit>>() {
            @Override
            public void onResult(List<Benefit> result) {
                if (result != null) {
                    Log.i(TAG, "Updating nearby benefits");
                    benefitsCompassView.setNearbyPlaces(result);
                    serviceCalled = true;
                } else {
                    Log.e(TAG, "Unable te get benefits, stopping service...");
                    service.stopService();
                    GlassDialog.warning(service.getApplicationContext(), "Unable to get benefits", "Check your internet connection");
                }
            }
        }).execute(location);
    }

    /**
     * Requests that the views redo their layout. This must be called manually every time the
     * tips view's text is updated because this layout doesn't exist in a GUI thread where those
     * requests will be enqueued automatically.
     */
    private void doLayout() {
        int measuredWidth = View.MeasureSpec.makeMeasureSpec(this.surfaceWidth, View.MeasureSpec.EXACTLY);
        int measuredHeight = View.MeasureSpec.makeMeasureSpec(this.surfaceHeight, View.MeasureSpec.EXACTLY);

        this.frameLayout.measure(measuredWidth, measuredHeight);
        this.frameLayout.layout(0, 0, this.frameLayout.getMeasuredWidth(), this.frameLayout.getMeasuredHeight());
    }

    private synchronized void repaint() {
        Canvas canvas = null;

        try {
            canvas = this.surfaceHolder.lockCanvas();
        } catch (RuntimeException e) {
            Log.d(TAG, "lockCanvas failed", e);
        }

        if (canvas != null) {
            canvas.drawColor(Color.BLACK);

            if (serviceCalled) {
                updateFrontBenefits();
                this.frameLayout.draw(canvas);
            } else {
                View syncView = new CardBuilder(this.service, CardBuilder.Layout.ALERT)
                        .setText("Loading nearby benefits")
                        .setIcon(syncIcon)
                        .getView();

                syncView.measure(640, 320);
                syncView.layout(0, 0, 0, 0);

                syncView.draw(canvas);
            }

            try {
                this.surfaceHolder.unlockCanvasAndPost(canvas);
            } catch (RuntimeException e) {
                Log.d(TAG, "unlockCanvasAndPost failed", e);
            }
        }
    }

    private void updateFrontBenefits() {
        Benefit frontBenefit = getFrontBenefit();

        if (frontBenefit != null) {
            this.benefitNameView.setText(frontBenefit.getName());
            this.benefitDescriptionView.setText(frontBenefit.getDescription());
        }
    }

    private void updateTipsView() {
        float tipsAlpha = 1.0f;
        float benefitsAlpha = 0.0f;

        if (this.isTooSteep) {
            this.tipsView.setText(R.string.pitch_too_steep);
            doLayout();
        } else if (this.hasMagneticInterference) {
            this.tipsView.setText(R.string.magnetic_interference);
            doLayout();
        } else {
            tipsAlpha = 0.0f;
            benefitsAlpha = 1.0f;
        }

        if (this.tipsContainer.getAnimation() == null) {
            this.tipsContainer.animate().alpha(tipsAlpha).start();
        }
        if (this.benefitsContainer.getAnimation() == null) {
            this.benefitsContainer.animate().alpha(benefitsAlpha).start();
        }
    }

    private class RenderThread extends Thread {
        private boolean shouldRun;

        public RenderThread() {
            shouldRun = true;
        }

        private synchronized boolean shouldRun() {
            return shouldRun;
        }

        public synchronized void quit() {
            shouldRun = false;
        }

        @Override
        public void run() {
            while (shouldRun()) {
                long frameStart = SystemClock.elapsedRealtime();
                repaint();
                long frameLength = SystemClock.elapsedRealtime() - frameStart;

                long sleepTime = FRAME_TIME_MILLIS - frameLength;
                if (sleepTime > 0) {
                    SystemClock.sleep(sleepTime);
                }
            }
        }
    }
}
