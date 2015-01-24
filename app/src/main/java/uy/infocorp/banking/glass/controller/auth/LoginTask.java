package uy.infocorp.banking.glass.controller.auth;

import android.util.Log;

import uy.infocorp.banking.glass.integration.privateapi.authentication.AuthenticationClient;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class LoginTask extends SimpleAsyncTask<String> {

    private static final String TAG = LoginTask.class.getSimpleName();

    public LoginTask(FinishedTaskListener<String> listener) {
        super(listener);
    }

    @Override
    protected String doInBackground(Object... params) {
        try {
            String pin = (String) params[0];
            //FIXME mapeo
            String authToken = AuthenticationClient.instance().completeLogOn();

            return authToken;
        } catch (Exception e) {
            Log.e(TAG, "Unable to fulfill login");
            return null;
        }
    }
}
