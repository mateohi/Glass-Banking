package uy.infocorp.banking.glass.controller.beacon.rate;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.domain.gesture.HeadGestureDetector;
import uy.infocorp.banking.glass.domain.gesture.HeadGestureListener;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.view.toast.GlassToast;

public class BranchRatingActivity extends Activity {

    public static final String BRANCH_ID = "branch_id";

    private static final String TAG = BranchRatingActivity.class.getSimpleName();

    private HeadGestureDetector headGestureDetector;
    private String branchId;
    private String bankName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.bankName = getResources().getString(R.string.bank_name);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        this.branchId = getIntent().getStringExtra(BRANCH_ID);

        createHeadGestureDetector();
        this.headGestureDetector.startListening();

        setContentView(buildView());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private View buildView() {
        return new CardBuilder(this, CardBuilder.Layout.TEXT)
                .setText("Rate your experience at " + bankName)
                .setTimestamp("Nod or shake your head")
                .getView();
    }

    private View buildLoadingView() {
        return new CardBuilder(this, CardBuilder.Layout.ALERT)
                .setText("Submitting review")
                .setIcon(R.drawable.loading_candy)
                .getView();
    }

    private void createHeadGestureDetector() {
        this.headGestureDetector = new HeadGestureDetector(getApplicationContext(), new HeadGestureListener() {
            @Override
            public void onNod() {
                positiveRating();
                headGestureDetector.stopListening();
            }

            @Override
            public void onHeadShake() {
                negativeRating();
                headGestureDetector.stopListening();
            }
        });
    }

    private void positiveRating() {
        Log.i(TAG, "Positive review on branch " + branchId);
        doRating(true);
    }

    private void negativeRating() {
        Log.i(TAG, "Negative review on branch " + branchId);
        doRating(false);
    }

    private void doRating(Boolean positive) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setContentView(buildLoadingView());
            }
        });

        new RateBranchTask(new FinishedTaskListener<Boolean>() {
            @Override
            public void onResult(Boolean resultOk) {
                showResultAndFinish(resultOk ? "Review posted" : "Unable to post review");
            }
        }).execute(branchId, positive);
    }

    private void showResultAndFinish(final String message) {
        playSound();
        GlassToast.done(this, message, Toast.LENGTH_LONG).show();
        finish();
    }

    private void playSound() {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.playSoundEffect(Sounds.SUCCESS);
    }
}
