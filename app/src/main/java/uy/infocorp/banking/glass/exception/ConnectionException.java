package uy.infocorp.banking.glass.exception;

public class ConnectionException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Unable to connect to host: [%s]";

    public ConnectionException(String host) {
        super(String.format(MESSAGE_FORMAT, host));
    }
}
