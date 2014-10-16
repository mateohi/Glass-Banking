package uy.infocorp.banking.glass.integration.privateapi.authentication;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SecurityQuestionsAnswers;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication.SignInInformation;
import uy.infocorp.banking.glass.util.http.RestClient;

/**
 * Created by german on 14/10/2014.
 */
public class AuthenticationClient {

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

    public SignInInformation logOn(String username, String password) throws UnsupportedEncodingException {
        return this.client.post(PrivateUrls.POST_SIGN_IN_URL, SignInInformation.class, new SignInInformation(username, password));
    }

    public SecurityQuestionsAnswers validateSecurityDevice(SecurityQuestionsAnswers securityQuestionsAnswers) throws UnsupportedEncodingException {
        return this.client.post(PrivateUrls.POST_VALIDATE_SECURITY_DEVICE_URL, SecurityQuestionsAnswers.class, securityQuestionsAnswers);
    }

}