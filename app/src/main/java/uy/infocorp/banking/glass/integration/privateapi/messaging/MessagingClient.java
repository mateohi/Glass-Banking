package uy.infocorp.banking.glass.integration.privateapi.messaging;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.messaging.Message;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;

public class MessagingClient {

    private static final String TAG = MessagingClient.class.getSimpleName();
    private static final String X_AUTH_TOKEN_HEADER_NAME = "X-Auth-Token";

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

    public List<Message> getInboxMessages(String authToken) throws UnsupportedEncodingException {
        if (Constants.OFFLINE_MODE) {
            return OfflineMessagingClient.getInboxMessages();
        }

        Header tokenHeader = new BasicHeader(X_AUTH_TOKEN_HEADER_NAME, authToken);
        Message[] messageList = builder.appendHeader(tokenHeader).execute(Message[].class);

        return Arrays.asList(messageList);
    }
}
