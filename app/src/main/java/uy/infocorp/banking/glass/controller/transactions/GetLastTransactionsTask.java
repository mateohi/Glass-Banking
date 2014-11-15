package uy.infocorp.banking.glass.controller.transactions;

import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.integration.privateapi.transfersHistory.TransferHistoryClient;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetLastTransactionsTask extends SimpleAsyncTask<List<Transfer>> {

    private static final String TAG = GetLastTransactionsTask.class.getSimpleName();

    public GetLastTransactionsTask(FinishedTaskListener<List<Transfer>> listener) {
        super(listener);
    }

    @Override
    protected List<Transfer> doInBackground(Object... params) {
        try {
            return TransferHistoryClient.instance().getLastTransfers();
        } catch (RuntimeException e) {
            Log.e(TAG, "Unable to get latest transactions -" + e.getMessage());
            return null;
        }
    }
}
