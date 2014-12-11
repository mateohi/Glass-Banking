package uy.infocorp.banking.glass.integration.privateapi.messaging;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.messaging.Message;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class MessagingClient extends BaseClient {

    private static final String TAG = MessagingClient.class.getSimpleName();

    private static String authToken;

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
        this.authToken = authToken;
        return (List<Message>) this.execute();
    }

    @Override
    protected Object getOffline() {
        Message[] messages = Resources.jsonToObject(R.raw.messages, Message[].class);
        return Arrays.asList(messages);
    }

    @Override
    protected Object getOnline() {
        String xAuthTokenHeaderName = Resources.getString(R.string.x_auth_header);
        Header tokenHeader = new BasicHeader(xAuthTokenHeaderName, this.authToken);
        Message[] messageList = builder.appendHeader(tokenHeader).execute(Message[].class);
        return Arrays.asList(messageList);
    }
}
