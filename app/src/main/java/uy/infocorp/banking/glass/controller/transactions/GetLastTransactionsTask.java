package uy.infocorp.banking.glass.controller.transactions;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.List;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.authentication.AuthenticationClient;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityDeviceValidationResult;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswers;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInResult;
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
            String authToken = getLoginAuthToken();
            return TransferHistoryClient.instance().getLastTransfers(authToken);
        } catch (RuntimeException e) {
            Log.e(TAG, "RuntimeException: Unable to get latest transactions -" + e.getMessage());
            return null;
        } catch (Exception exc){
            Log.e(TAG, "Unable to get latest transactions -" + exc.getMessage());
            return null;
        }
    }

    /**
     * Try to login and get the Authentication Token
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    private String getLoginAuthToken() throws UnsupportedEncodingException {
        if(Constants.OFFLINE_MODE){//test
            return "test";
        }
        //1- LogOn
        SignInResult signInResult = AuthenticationClient.instance().logOn("prueba09", "1234");
        //ToDo: Validar success en respuesta a login (usuario bloqueado, password invalido, etc)
        Integer secretQuestionId = Integer.parseInt(signInResult.getSignInInformation().getSecurityQuestionsToAnswerForLoginDevice().get(0).getSecurityQuestionId());
        SecurityQuestionsAnswers questionAnswered = new SecurityQuestionsAnswers(secretQuestionId, "1111");
        //2- Security Device Validation
        SecurityDeviceValidationResult securityDeviceValidationResult =
                AuthenticationClient.instance().validateSecurityDevice(questionAnswered,
                        signInResult.getAuthToken());
        //ToDo: Validar success en respuesta a las preguntas de seguridad.
        return securityDeviceValidationResult.getAuthToken();
    }
}
