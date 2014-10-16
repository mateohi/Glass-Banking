package uy.infocorp.banking.glass.integration.privateapi.common.dto.authentication;

import java.util.ArrayList;

/**
 * Created by german on 15/10/2014.
 */
public class SecurityQuestionsAnswers {

    private ArrayList<SecurityQuestionAnswer> securityQuestionAnswer;

    public SecurityQuestionsAnswers(){
    }

    public ArrayList<SecurityQuestionAnswer> getSecurityQuestionAnswer() {
        return securityQuestionAnswer;
    }

    public void setSecurityQuestionAnswer(ArrayList<SecurityQuestionAnswer> securityQuestionAnswer) {
        this.securityQuestionAnswer = securityQuestionAnswer;
    }
}
