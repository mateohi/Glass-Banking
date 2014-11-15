package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

import java.util.List;

public class SignInInformation {

    private String username;
    private String password;
    private List<SecurityQuestionsToAnswerForLoginDevice> securityQuestionsToAnswerForLoginDevice;

    public SignInInformation(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SecurityQuestionsToAnswerForLoginDevice> getSecurityQuestionsToAnswerForLoginDevice() {
        return securityQuestionsToAnswerForLoginDevice;
    }

    public void setSecurityQuestionsToAnswerForLoginDevice(List<SecurityQuestionsToAnswerForLoginDevice> securityQuestionsToAnswerForLoginDevice) {


    }
}
