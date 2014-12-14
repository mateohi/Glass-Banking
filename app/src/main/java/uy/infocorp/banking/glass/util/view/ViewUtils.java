package uy.infocorp.banking.glass.util.view;

import android.view.View;
import android.widget.TextView;

public class ViewUtils {

    public static final String ILLEGAL_ARGUMENT_MESSAGE = "View with id [%d] is not an instance of TextView";

    public static void setTextViewText(View parent, int viewId, String text) {
        View view = parent.findViewById(viewId);

        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setText(text);
        } else {
            throw new IllegalArgumentException(String.format(ILLEGAL_ARGUMENT_MESSAGE, viewId));
        }
    }
}
