package uy.infocorp.banking.glass.integration.privateapi.transfer.dto.response;

public class TransferResponse {

    private TransactionBackendResponse transactionBackendResponse;
    private String operationResult;

    public TransactionBackendResponse getTransactionBackendResponse() {
        return transactionBackendResponse;
    }

    public void setTransactionBackendResponse(TransactionBackendResponse transactionBackendResponse) {
        this.transactionBackendResponse = transactionBackendResponse;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public boolean wasSuccessful() {
        return "success".equals(this.operationResult);
    }
}
