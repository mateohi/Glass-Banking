package uy.infocorp.banking.glass.util.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.view.MotionEvent;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardBuilder;

public class AlertDialog extends Dialog {

    private final DialogInterface.OnClickListener listener;
    private final AudioManager audioManager;
    private final GestureDetector gestureDetector;

    private final GestureDetector.BaseListener baseListener = new GestureDetector.BaseListener() {

        @Override
        public boolean onGesture(Gesture gesture) {
            if (gesture == Gesture.TAP) {
                audioManager.playSoundEffect(Sounds.TAP);
                dismiss();
                if (listener != null) {
                    // Since Glass dialogs do not have buttons,
                    // the index passed to onClick is always 0.
                    listener.onClick(AlertDialog.this, 0);
                }
                return true;
            }
            return false;
        }
    };

    public AlertDialog(Context context, int iconId, int textId, int footnoteId,
                       DialogInterface.OnClickListener onClickListener) {
        super(context);

        listener = onClickListener;
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        gestureDetector = new GestureDetector(context).setBaseListener(baseListener);

        setContentView(new CardBuilder(context, CardBuilder.Layout.ALERT)
                .setIcon(iconId)
                .setText(textId)
                .setFootnote(footnoteId)
                .getView());
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return gestureDetector.onMotionEvent(event) || super.onGenericMotionEvent(event);
    }
}
