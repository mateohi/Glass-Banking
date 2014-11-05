package uy.infocorp.banking.glass.integration.privateapi.authentication;

import android.util.Log;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityDeviceValidationResult;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswers;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswersList;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInInformation;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInResult;
import uy.infocorp.banking.glass.util.http.RestClientBuilder;

/**
 * Created by german on 14/10/2014.
 */
public class AuthenticationClient {

    private static final String TAG = AuthenticationClient.class.getSimpleName();
    private static final String X_AUTH_TOKEN_HEADER_NAME = "X-Auth-Token";

    private static AuthenticationClient instance;
    private RestClientBuilder client;

    private AuthenticationClient() {
        client = new RestClientBuilder();
    }

    public static AuthenticationClient instance() {
        if (instance == null) {
            instance = new AuthenticationClient();
        }
        return instance;
    }

    public SignInResult logOn(String username, String password) throws UnsupportedEncodingException {
        SignInInformation signInInformation = new SignInInformation(username, password);
        RestClientBuilder restClient = new RestClientBuilder();
        //initialize and execute post
        Pair<SignInResult, List<Header>> data = restClient.post(PrivateUrls.POST_SIGN_IN_URL, signInInformation).
                                                executeAndGetHeaders(SignInResult.class);

        SignInResult result = data.getLeft();
        List<Header> headers = data.getRight();
        //gets the header x_auth_token
        Header authToken = null;
        for (int i = 0; i < headers.size(); i++) {
            if(headers.get(i).getName().equals(X_AUTH_TOKEN_HEADER_NAME)){
                authToken = headers.get(i);
                break;
            }
        }
        if(authToken !=null){
            result.setAuthToken(authToken.getValue());
        }else{
            Log.i(TAG, "No se pudo obtener el header X-Auth-Token al intentar loguearse");

        }
        return result;
    }

    public SecurityDeviceValidationResult validateSecurityDevice(SecurityQuestionsAnswers securityQuestionsAnswers, String signInAuthToken)
            throws UnsupportedEncodingException {

        RestClientBuilder restClient = new RestClientBuilder();
        SecurityQuestionsAnswersList request = new SecurityQuestionsAnswersList();
        request.getSecurityQuestionsAnswers().add(securityQuestionsAnswers);
        //do post
        Pair<SecurityDeviceValidationResult, List<Header>> data = restClient.post(PrivateUrls.POST_VALIDATE_SECURITY_DEVICE_URL, request).
                                                appendHeader(new BasicHeader(X_AUTH_TOKEN_HEADER_NAME, signInAuthToken)).
                                                executeAndGetHeaders(SecurityDeviceValidationResult.class);
        SecurityDeviceValidationResult result = data.getLeft();
        List<Header> responseHeaders = data.getRight();
        //gets the header corresponding to the x_auth_token
        Header authToken = null;
        for (int i = 0; i < responseHeaders.size(); i++) {
            if(responseHeaders.get(i).getName().equals(X_AUTH_TOKEN_HEADER_NAME)){
                authToken = responseHeaders.get(i);
                break;
            }
        }
        if(authToken !=null){
            result.setAuthToken(authToken.getValue());
        }else{
            Log.i(TAG, "No se pudo obtener el header X-Auth-Token al intentar validar el dispositivo de seguridad");
        }
        return result;
    }
}