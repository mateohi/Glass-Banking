package uy.infocorp.banking.glass.controller.transfer.own;

import android.util.Log;

import uy.infocorp.banking.glass.domain.transfer.builder.TransferRequestBuilder;
import uy.infocorp.banking.glass.integration.privateapi.authentication.AuthenticationClient;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.transfer.dto.TransferOwnAccountClient;
import uy.infocorp.banking.glass.integration.privateapi.transfer.dto.request.TransferRequest;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class TransferBetweenOwnAccountsTask extends SimpleAsyncTask<Boolean> {

    private static final String TAG = TransferBetweenOwnAccountsTask.class.getSimpleName();

    public TransferBetweenOwnAccountsTask(FinishedTaskListener<Boolean> listener) {
        super(listener);
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        try {
            int amount = (Integer) params[0];
            Product debitProduct = (Product) params[1];
            Product creditProduct = (Product) params[2];
            String authToken = AuthenticationClient.instance().completeLogOn();

            TransferRequest request = TransferRequestBuilder.betweenOwnAccounts(amount,
                    debitProduct, creditProduct);
            TransferOwnAccountClient.instance().makeTransferBetweenOwnAccounts(authToken, request);

            return true;
        } catch (Exception e) {
            Log.e(TAG, "Unable to get complete transfer - " + e.getMessage());
            return false;
        }
    }
}
