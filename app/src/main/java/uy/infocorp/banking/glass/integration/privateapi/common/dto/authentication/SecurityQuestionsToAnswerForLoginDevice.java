package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

/**
 * Created by german on 15/11/2014.
 */
public class SecurityQuestionsToAnswerForLoginDevice {

    private String securityQuestionId;
    private String securityQuestionDescription;

    public String getSecurityQuestionId() {
        return securityQuestionId;
    }

    public void setSecurityQuestionId(String securityQuestionId) {
        this.securityQuestionId = securityQuestionId;
    }

    public String getSecurityQuestionDescription() {
        return securityQuestionDescription;
    }

    public void setSecurityQuestionDescription(String securityQuestionDescription) {
        this.securityQuestionDescription = securityQuestionDescription;
    }
}
