package uy.infocorp.banking.glass.exception;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class ServerException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Host: [%s] gave response: %d - %s";

    public ServerException(String host, HttpResponse httpResponse) {
        super(buildMessage(host, httpResponse));
    }

    private static String buildMessage(String host, HttpResponse httpResponse) {
        StatusLine statusLine = httpResponse.getStatusLine();
        int httpCode = statusLine.getStatusCode();
        String reasonPhrase = statusLine.getReasonPhrase();

        return String.format(MESSAGE_FORMAT, host, httpCode, reasonPhrase);
    }
}
