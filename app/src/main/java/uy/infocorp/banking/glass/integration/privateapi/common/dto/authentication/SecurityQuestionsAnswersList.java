package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 04/11/2014.
 */
public class SecurityQuestionsAnswersList {

    private List<SecurityQuestionsAnswers> securityQuestionsAnswers;

    public SecurityQuestionsAnswersList(){
        securityQuestionsAnswers = new ArrayList<SecurityQuestionsAnswers>();
    }

    public List<SecurityQuestionsAnswers> getSecurityQuestionsAnswers() {
        return securityQuestionsAnswers;
    }

    public void setSecurityQuestionsAnswers(List<SecurityQuestionsAnswers> securityQuestionsAnswers) {
        this.securityQuestionsAnswers = securityQuestionsAnswers;
    }
}
