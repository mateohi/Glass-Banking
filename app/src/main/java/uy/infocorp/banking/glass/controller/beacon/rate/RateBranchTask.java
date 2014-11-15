package uy.infocorp.banking.glass.controller.beacon.rate;

import android.util.Log;

import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class RateBranchTask extends SimpleAsyncTask<Boolean> {

    private static final String TAG = RateBranchTask.class.getSimpleName();

    public RateBranchTask(FinishedTaskListener<Boolean> listener) {
        super(listener);
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        try {
            String branchId = (String) params[0];
            Boolean positive = (Boolean) params[1];
            // TODO pegarle al servicio con el rating
            return true;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }
}
