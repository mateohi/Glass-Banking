package uy.infocorp.banking.glass.controller.transactions;

import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetLastTransactionsTask extends SimpleAsyncTask<List> {

    private static final String TAG = GetLastTransactionsTask.class.getSimpleName();

    public GetLastTransactionsTask(FinishedTaskListener<List> listener) {
        super(listener);
    }

    @Override
    protected List doInBackground(Object... params) {
        try {
            // TODO pegarle al servicio de la api privada
            throw new UnsupportedOperationException();
        }
        catch (RuntimeException e) {
            Log.e(TAG, "Unable to get latest transactions -" + e.getMessage());
            return null;
        }
    }
}
