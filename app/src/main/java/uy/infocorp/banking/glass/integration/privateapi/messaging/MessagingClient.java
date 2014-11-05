package uy.infocorp.banking.glass.integration.privateapi.messaging;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;

public class MessagingClient {

    private static MessagingClient instance;
    private RestExecutionBuilder builder;

    private MessagingClient() {
        builder = RestExecutionBuilder.get(PrivateUrls.GET_INBOX_MESSAGES_URL);
    }

    public static MessagingClient instance() {
        if (instance == null) {
            instance = new MessagingClient();
        }
        return instance;
    }

    public void getInboxMessages() throws UnsupportedEncodingException {
//        return this.builder.execute(Message.class);
    }
/*
    public SecurityQuestionsAnswers validateSecurityDevice(SecurityQuestionsAnswers securityQuestionsAnswers) throws UnsupportedEncodingException {
        return this.client.post(PrivateUrls.POST_VALIDATE_SECURITY_DEVICE_URL, SecurityQuestionsAnswers.class, securityQuestionsAnswers);
    }
*/

}
