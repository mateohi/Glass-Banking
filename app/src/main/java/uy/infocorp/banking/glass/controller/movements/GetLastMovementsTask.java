package uy.infocorp.banking.glass.controller.movements;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.authentication.AuthenticationClient;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityDeviceValidationResult;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswers;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInResult;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;
import uy.infocorp.banking.glass.integration.privateapi.movementsHistory.MovementHistoryClient;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetLastMovementsTask extends SimpleAsyncTask<List<Movement>> {

    private static final String TAG = GetLastMovementsTask.class.getSimpleName();

    public GetLastMovementsTask(FinishedTaskListener<List<Movement>> listener) {
        super(listener);
    }

    @Override
    protected List<Movement> doInBackground(Object... params) {
        try {
            String authToken = AuthenticationClient.instance().completeLogOn();
            return MovementHistoryClient.instance().getLastMovements(authToken);
        } catch (RuntimeException e) {
            Log.e(TAG, "RuntimeException: Unable to get latest transactions -" + e.getMessage());
            return null;
        } catch (Exception exc){
            Log.e(TAG, "Unable to get latest transactions -" + exc.getMessage());
            return null;
        }
    }


}
