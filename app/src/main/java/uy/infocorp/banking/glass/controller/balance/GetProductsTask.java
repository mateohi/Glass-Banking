package uy.infocorp.banking.glass.controller.balance;

import android.accounts.AccountManager;
import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.authentication.AuthenticationClient;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.products.ProductsClient;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;
import uy.infocorp.banking.glass.util.resources.Resources;

public class GetProductsTask extends SimpleAsyncTask<List<Product>> {

    private static final String TAG = GetProductsTask.class.getSimpleName();

    public GetProductsTask(FinishedTaskListener<List<Product>> listener) {
        super(listener);
    }

    @Override
    protected List<Product> doInBackground(Object... params) {
        try {
            Thread.sleep(1000);
            String authToken = AuthenticationClient.instance().completeLogOn();
            // Load Consolidate Position
            return ProductsClient.instance().getConsolidatedPosition(authToken);
        } catch (Exception e) {
            Log.e(TAG, "Unable to get list of Products -" + e.getMessage());
            return null;
        }
    }

}
