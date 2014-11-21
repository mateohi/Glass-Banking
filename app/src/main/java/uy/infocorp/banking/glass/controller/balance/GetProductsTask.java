package uy.infocorp.banking.glass.controller.balance;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.util.List;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.authentication.AuthenticationClient;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityDeviceValidationResult;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswers;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInResult;
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
            String authToken = getLoginAuthToken();
            // Load Consolidate Position
            return ProductsClient.instance().getConsolidatedPosition(authToken);
        } catch (Exception e) {
            Log.e(TAG, "Unable to get list of Products -" + e.getMessage());
            return null;
        }
    }

    /**
     * Try to login and get the Authentication Token
     * @return
     * @throws UnsupportedEncodingException
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
