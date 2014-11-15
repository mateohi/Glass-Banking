package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.administration.users.User;

/**
 * Created by german on 04/11/2014.
 */
public class SignInResult {

    private String loginDevice;
    private SignInInformation signInInformation;
    private User user;
    private String result;
    private String authToken;

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    public SignInInformation getSignInInformation() {
        return signInInformation;
    }

    public void setSignInInformation(SignInInformation signInInformation) {
        this.signInInformation = signInInformation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }

}
