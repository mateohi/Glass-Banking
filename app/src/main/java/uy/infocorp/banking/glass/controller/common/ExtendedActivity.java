package uy.infocorp.banking.glass.controller.common;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public abstract class ExtendedActivity extends Activity {

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

    protected void delayedFinish(int seconds) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, TimeUnit.SECONDS.toMillis(seconds));
    }

    protected void delayedFinish() {
        delayedFinish(1);
    }
}
