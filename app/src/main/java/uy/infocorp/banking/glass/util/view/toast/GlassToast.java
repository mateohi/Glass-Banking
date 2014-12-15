package uy.infocorp.banking.glass.util.view.toast;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.android.glass.widget.CardBuilder;

import uy.infocorp.banking.glass.R;

public class GlassToast {

    public static Toast create(Context context, String message, int duration, int drawable) {
        View view = new CardBuilder(context, CardBuilder.Layout.ALERT)
                .setText(message)
                .setIcon(drawable)
                .getView();

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.FILL, 0, 0);
        toast.setView(view);
        toast.setDuration(duration);

        return toast;
    }

    public static Toast done(Context context, String message, int duration) {
        return create(context, message, duration, R.drawable.ic_done_150);
    }

    public static Toast warn(Context context, String message, int duration) {
        return create(context, message, duration, R.drawable.ic_warning_150);
    }
}
