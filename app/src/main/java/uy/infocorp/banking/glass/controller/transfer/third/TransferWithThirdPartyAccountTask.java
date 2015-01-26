package uy.infocorp.banking.glass.controller.transfer.third;

import android.util.Log;

import uy.infocorp.banking.glass.domain.transfer.builder.TransferRequestBuilder;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.ThirdPartyAccount;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.transfer.TransferThirdPartyAccountClient;
import uy.infocorp.banking.glass.integration.privateapi.transfer.dto.request.TransferRequest;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class TransferWithThirdPartyAccountTask extends SimpleAsyncTask<Boolean> {

    private static final String TAG = TransferWithThirdPartyAccountTask.class.getSimpleName();

    public TransferWithThirdPartyAccountTask(FinishedTaskListener<Boolean> listener) {
        super(listener);
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        try {
            String authToken = (String) params[0];
            int amount = (Integer) params[1];
            Product debitProduct = (Product) params[2];
            ThirdPartyAccount creditAccount = (ThirdPartyAccount) params[3];

            TransferRequest request = TransferRequestBuilder.betweenThirdPartyAccounts(amount, debitProduct, creditAccount);
            TransferThirdPartyAccountClient.instance().makeLocalTransfer(authToken, request);

            return true;
        } catch (Exception e) {
            Log.e(TAG, "Unable to get complete transfer - " + e.getMessage());
            return false;
        }
    }
}
