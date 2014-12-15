package uy.infocorp.banking.glass.util.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardBuilder;

import uy.infocorp.banking.glass.R;

public class DialogActivity extends Activity {

    public static final String TYPE = "type";
    public static final String MESSAGE = "message";
    public static final String TIP = "tip";

    public static final String INFO = "info";
    public static final String WARNING = "warning";
    public static final String DONE = "done";

    private static final String UNDEFINED_TYPE = "Undefined type %s in DialogActivity";
    private static final String NO_MESSAGE = "No message received in intent";

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.gestureDetector = createGestureDetector();

        View view = getView(getIntent());
        setContentView(view);
    }

    private View getView(Intent intent) {
        String type = intent.getStringExtra(TYPE);
        String message = intent.getStringExtra(MESSAGE);
        String tip = intent.getStringExtra(TIP);

        if (message == null) {
            throw new IllegalArgumentException(NO_MESSAGE);
        }

        if (INFO.equals(type)) {
            return createNotice(message, tip, R.drawable.ic_help);
        } else if (WARNING.equals(type)) {
            return createNotice(message, tip, R.drawable.ic_warning_150);
        } else if (DONE.equals(type)) {
            return createNotice(message, tip, R.drawable.ic_done_150);
        } else {
            throw new IllegalArgumentException(String.format(UNDEFINED_TYPE, type));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dialog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_dismiss) {
            dismissSound();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private View createNotice(String message, String tip, int imageId) {
        Bitmap image = BitmapFactory.decodeResource(getResources(), imageId);

        return new CardBuilder(getApplicationContext(), CardBuilder.Layout.ALERT)
                .setFootnote(tip)
                .setText(message)
                .setIcon(image)
                .getView();
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (this.gestureDetector != null) {
            return this.gestureDetector.onMotionEvent(event);
        }
        return false;
    }

    private void dismissSound() {
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audio.playSoundEffect(Sounds.DISMISSED);
    }

    private GestureDetector createGestureDetector() {
        GestureDetector gestureDetector = new GestureDetector(this);
        //Create a base listener for generic gestures
        gestureDetector.setBaseListener(new GestureDetector.BaseListener() {
            @Override
            public boolean onGesture(Gesture gesture) {
                if (gesture == Gesture.TAP) {

                    finish();
                    return true;
                }
                return false;
            }
        });
        gestureDetector.setFingerListener(new GestureDetector.FingerListener() {
            @Override
            public void onFingerCountChanged(int previousCount, int currentCount) {
            }
        });
        gestureDetector.setScrollListener(new GestureDetector.ScrollListener() {
            @Override
            public boolean onScroll(float displacement, float delta, float velocity) {
                return false;
            }
        });
        return gestureDetector;
    }
}
