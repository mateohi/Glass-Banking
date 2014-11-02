package uy.infocorp.banking.glass.controller.balance;

import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.products.ProductsClient;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

/**
 * Created by german on 02/11/2014.
 */
public class GetProductsTask extends SimpleAsyncTask<List<Product>> {
    private static final String TAG = GetProductsTask.class.getSimpleName();

    public GetProductsTask(FinishedTaskListener<List<Product>> listener) {
        super(listener);
    }

    @Override
    protected List<Product> doInBackground(Object... params) {
        try {
            return ProductsClient.instance().getConsolidatedPosition();
        }
        catch (Exception e) {
            Log.e(TAG, "Unable to get list of Products -" + e.getMessage());
            return null;
        }
    }

}
