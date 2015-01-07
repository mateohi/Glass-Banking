package uy.infocorp.banking.glass.controller.common;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class EditableActivity extends Activity {

    protected void setTextViewText(int id, String text) {
        TextView tv = (TextView) findViewById(id);
        tv.setText(text);
    }

    protected void setTextViewText(View view, int id, String text) {
        TextView tv = (TextView) view.findViewById(id);
        tv.setText(text);
    }

    protected String getTextViewText(int id) {
        TextView tv = (TextView) findViewById(id);
        return tv.getText().toString();
    }
}
