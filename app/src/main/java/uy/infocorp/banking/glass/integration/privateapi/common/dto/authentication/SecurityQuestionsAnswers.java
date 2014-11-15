package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

/**
 * Created by german on 15/10/2014.
 */
public class SecurityQuestionsAnswers {

    private int securityQuestionId;
    private String answer;

    public SecurityQuestionsAnswers(int securityQuestionId, String answer) {
        this.securityQuestionId = securityQuestionId;
        this.answer = answer;
    }

    public int getSecurityQuestionId() {
        return securityQuestionId;
    }

    public void setSecurityQuestionId(int securityQuestionId) {
        this.securityQuestionId = securityQuestionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

