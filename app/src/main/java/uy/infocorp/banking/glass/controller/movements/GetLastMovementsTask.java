package uy.infocorp.banking.glass.controller.movements;

import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.authentication.AuthenticationClient;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.ProductType;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;
import uy.infocorp.banking.glass.integration.privateapi.movementsHistory.MovementHistoryClient;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;
import uy.infocorp.banking.glass.util.resources.Resources;

public class GetLastMovementsTask extends SimpleAsyncTask<List<Movement>> {

    private static final String TAG = GetLastMovementsTask.class.getSimpleName();

    public GetLastMovementsTask(FinishedTaskListener<List<Movement>> listener) {
        super(listener);
    }

    @Override
    protected List<Movement> doInBackground(Object... params) {
        try {
            String productBankIdentifier = (String) params[0];
            ProductType productType = (ProductType) params[1];
            return MovementHistoryClient.instance().getLastMovements(productType,
                                                                    productBankIdentifier);
        } catch (RuntimeException e) {
            Log.e(TAG, "RuntimeException: Unable to get latest transactions -" + e.getMessage());
            return null;
        } catch (Exception exc) {
            Log.e(TAG, "Unable to get latest transactions -" + exc.getMessage());
            return null;
        }
    }


}
