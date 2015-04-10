package uy.infocorp.banking.glass.controller.auth;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.Slider;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.controller.common.ExtendedActivity;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;

public class AuthenticationActivity extends ExtendedActivity {

    public static final String AUTH_TOKEN_EXTRA = "AUTH_TOKEN";
    private static final int TEN = 10;
    private static final int PIN_SIZE = 4;

    private List<Integer> selected = Lists.newArrayList();
    private double velocity;
    private int selection;
    private View view;

    private GestureDetector gestureDetector;
    private AudioManager audio;

    private Slider.Indeterminate slider;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        selection = 0;
        gestureDetector = createGestureDetector();
        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        view = new CardBuilder(this, CardBuilder.Layout.EMBED_INSIDE)
                .setEmbeddedLayout(R.layout.pin)
                .setFootnote("scroll to change selection")
                .getView();

        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (gestureDetector != null) {
            return gestureDetector.onMotionEvent(event);
        }
        return false;
    }

    private GestureDetector createGestureDetector() {
        GestureDetector gestureDetector = new GestureDetector(this);
        gestureDetector.setBaseListener(new GestureDetector.BaseListener() {
            @Override
            public boolean onGesture(Gesture gesture) {
                if (gesture == Gesture.TAP) {
                    selectedNumber();
                } else if (gesture == Gesture.SWIPE_LEFT) {
                    changeNumbers(true);
                } else if (gesture == Gesture.SWIPE_RIGHT) {
                    changeNumbers(false);
                }
                return false;
            }
        });
        gestureDetector.setScrollListener(new GestureDetector.ScrollListener() {
            @Override
            public boolean onScroll(float displacement, float delta, float velocity) {
                AuthenticationActivity.this.velocity = Math.abs(velocity);
                return true;
            }
        });
        return gestureDetector;
    }

    private void selectedNumber() {
        audio.playSoundEffect(Sounds.SELECTED);
        selected.add(selection);

        if (selected.size() == PIN_SIZE) {
            String pin = StringUtils.join(selected);
            doLogin(pin);
        }

        String mask = StringUtils.join(selected, " ");
        String rest = StringUtils.repeat('_', PIN_SIZE - selected.size()).replace("", " ").trim();

        TextView tv = (TextView) view.findViewById(R.id.mask);
        tv.setText(mask + " " + rest);
    }

    private void changeNumbers(final boolean fromLeft) {
        int movements = 1;
        if (velocity > 9) {
            movements = 3;
        } else if (velocity > 6) {
            movements = 2;
        }

        Handler handler = new Handler();
        for (int i = 0; i < movements; i++) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selection = circularInt(fromLeft ? 1 : -1);
                    updateView(fromLeft);
                }
            }, 100 + (100 * i));
        }
    }

    private void updateView(boolean fromLeft) {
        setTextViewTextAndAnimate(circular(-2), R.id.first, fromLeft);
        setTextViewTextAndAnimate(circular(-1), R.id.second, fromLeft);
        setTextViewTextAndAnimate(circular(0), R.id.third, fromLeft);
        setTextViewTextAndAnimate(circular(1), R.id.fourth, fromLeft);
        setTextViewTextAndAnimate(circular(2), R.id.fifth, fromLeft);
    }

    private void setTextViewTextAndAnimate(String text, int id, boolean fromLeft) {
        int animationId = fromLeft ? R.anim.right_to_left : R.anim.left_to_right;
        Animation animation = AnimationUtils.loadAnimation(this, animationId);

        TextView tv = (TextView) view.findViewById(id);
        tv.startAnimation(animation);
        tv.setText(text);
    }

    private String circular(int n) {
        return String.valueOf(circularInt(n));
    }

    private int circularInt(int n) {
        return (selection + n + TEN) % TEN;
    }

    private void doLogin(String pin) {
        showLoggingView();

        new LoginTask(new FinishedTaskListener<String>() {
            @Override
            public void onResult(String authToken) {
                slider.hide();
                slider = null;

                returnToAuthenticableActivity(authToken);
            }
        }).execute(pin);
    }

    private void returnToAuthenticableActivity(String authtoken) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(AUTH_TOKEN_EXTRA, authtoken);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    private void showLoggingView() {
        View loginView = new CardBuilder(this, CardBuilder.Layout.MENU)
                .setText("Attempting login ...")
                .setIcon(R.drawable.ic_sync)
                .getView();

        this.slider = Slider.from(loginView).startIndeterminate();

        setContentView(loginView);
    }
}
