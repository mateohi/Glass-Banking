package uy.infocorp.banking.glass.exception;

public class ResourceParsingException extends RuntimeException {

    public ResourceParsingException(String errorMessage) {
        super("Unable to parse resource json, " + errorMessage);
    }
}
