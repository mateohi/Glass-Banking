package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

/**
 * Created by german on 15/10/2014.
 */
public class SecurityQuestionAnswer {

    private String securityQuestionId;
    private String answer;

    public SecurityQuestionAnswer(String securityQuestionId, String answer){
        this.securityQuestionId = securityQuestionId;
        this.answer = answer;
    }

    public String getSecurityQuestionId() {
        return securityQuestionId;
    }

    public void setSecurityQuestionId(String securityQuestionId) {
        this.securityQuestionId = securityQuestionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

