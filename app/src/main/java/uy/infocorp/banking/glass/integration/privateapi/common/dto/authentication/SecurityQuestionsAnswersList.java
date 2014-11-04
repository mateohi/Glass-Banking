package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by german on 04/11/2014.
 */
public class SecurityQuestionsAnswersList {

    private ArrayList<SecurityQuestionsAnswers> securityQuestionsAnswers;

    public SecurityQuestionsAnswersList(){
        securityQuestionsAnswers = new ArrayList<SecurityQuestionsAnswers>();
    }

    public List<SecurityQuestionsAnswers> getSecurityQuestionsAnswers() {
        return securityQuestionsAnswers;
    }

    public void setSecurityQuestionsAnswers(ArrayList<SecurityQuestionsAnswers> securityQuestionsAnswers) {
        this.securityQuestionsAnswers = securityQuestionsAnswers;
    }
}
