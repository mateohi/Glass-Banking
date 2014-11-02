package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

import java.util.List;

public class SecurityQuestionsAnswers {

    private List<SecurityQuestionAnswer> securityQuestionAnswers;

    public SecurityQuestionsAnswers() {
    }

    public List<SecurityQuestionAnswer> getSecurityQuestionAnswer() {
        return securityQuestionAnswers;
    }

    public void setSecurityQuestionAnswer(List<SecurityQuestionAnswer> securityQuestionAnswers) {
        this.securityQuestionAnswers = securityQuestionAnswers;
    }
}
