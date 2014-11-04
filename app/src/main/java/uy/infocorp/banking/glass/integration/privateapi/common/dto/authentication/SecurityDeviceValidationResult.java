package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

/**
 * Created by german on 04/11/2014.
 */
public class SecurityDeviceValidationResult {

    private String result;
    private String authToken;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
