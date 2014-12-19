package uy.infocorp.banking.glass.controller.beacon.rate;

import android.os.AsyncTask;
import android.util.Log;

public class InformArrivalTask extends AsyncTask<String, Void, Void> {

    private static final String TAG = InformArrivalTask.class.getSimpleName();

    @Override
    protected Void doInBackground(String... params) {
        String id = params[0];
        Integer placeId = Integer.parseInt(params[1]);

        try {

        } catch (Exception ex) {
            Log.e(TAG, "Unable to inform arrival of user", ex);
        }

        return null;
    }
}
