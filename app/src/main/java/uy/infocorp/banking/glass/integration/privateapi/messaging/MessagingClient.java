package uy.infocorp.banking.glass.integration.privateapi.messaging;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.util.http.RestClient;

/**
 * Created by german on 15/10/2014.
 */
public class MessagingClient {
    private static MessagingClient instance;
    private RestClient client;

    private MessagingClient () {
        client = new RestClient();
    }

    public static MessagingClient instance() {
        if (instance == null) {
            instance = new MessagingClient();
        }
        return instance;
    }

    public void getInboxMessages() throws UnsupportedEncodingException {
//        return this.client.get(PrivateUrls.GET_INBOX_MESSAGES_URL, Message.class);
    }
/*
    public SecurityQuestionsAnswers validateSecurityDevice(SecurityQuestionsAnswers securityQuestionsAnswers) throws UnsupportedEncodingException {
        return this.client.post(PrivateUrls.POST_VALIDATE_SECURITY_DEVICE_URL, SecurityQuestionsAnswers.class, securityQuestionsAnswers);
    }
*/

}
