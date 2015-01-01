package uy.infocorp.banking.glass.integration.privateapi.transfer.dto.response;

public class TransactionBackendResponse {

    private Integer transactionId;
    private String backendCode;
    private String transactionValidateResult;
    private Boolean hasError;
    private Boolean backendIsError;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getBackendCode() {
        return backendCode;
    }

    public void setBackendCode(String backendCode) {
        this.backendCode = backendCode;
    }

    public String getTransactionValidateResult() {
        return transactionValidateResult;
    }

    public void setTransactionValidateResult(String transactionValidateResult) {
        this.transactionValidateResult = transactionValidateResult;
    }

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public Boolean getBackendIsError() {
        return backendIsError;
    }

    public void setBackendIsError(Boolean backendIsError) {
        this.backendIsError = backendIsError;
    }
}
