package uy.infocorp.banking.glass.integration.privateapi.authentication;

import android.util.Log;
import android.util.Pair;

import com.google.gson.Gson;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityDeviceValidationResult;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswers;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswersList;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInInformation;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInResult;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.OperationResult;
import uy.infocorp.banking.glass.util.http.RestClient;

/**
 * Created by german on 14/10/2014.
 */
public class AuthenticationClient {

    private static final String TAG = AuthenticationClient.class.getSimpleName();
    private static final String X_AUTH_TOKEN_HEADER_NAME = "X-Auth-Token";

    private static AuthenticationClient instance;
    private RestClient client;

    private AuthenticationClient() {
        client = new RestClient();
    }

    public static AuthenticationClient instance() {
        if (instance == null) {
            instance = new AuthenticationClient();
        }
        return instance;
    }

    public SignInResult logOn(String username, String password) throws UnsupportedEncodingException {
        SignInInformation signInInformation = new SignInInformation(username, password);
        Pair<SignInResult, List<Header>> data = this.client.post(PrivateUrls.POST_SIGN_IN_URL,
                SignInResult.class, signInInformation, null);
        SignInResult result = data.first;
        List<Header> headers = data.second;
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
        //add x_auth_token header
        List<Header> requestHeaders = new ArrayList<Header>();
        requestHeaders.add(new BasicHeader(X_AUTH_TOKEN_HEADER_NAME, signInAuthToken));
        Log.i(TAG, new Gson().toJson(securityQuestionsAnswers));
        //do post
        SecurityQuestionsAnswersList request = new SecurityQuestionsAnswersList();
        request.getSecurityQuestionsAnswers().add(securityQuestionsAnswers);
        Pair<SecurityDeviceValidationResult, List<Header>> data = this.client.post(PrivateUrls.POST_VALIDATE_SECURITY_DEVICE_URL,
                SecurityDeviceValidationResult.class, request, requestHeaders);
        SecurityDeviceValidationResult result = data.first;
        List<Header> responseHeaders = data.second;
        //gets the header x_auth_token
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