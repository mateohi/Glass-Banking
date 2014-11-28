package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.transactions;

import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.security.SecurityDevice;

public class TransactionBackendResponse {

    private String backendCode;
    private String backendReference;
    private String backendMessage;
    private boolean backendIsError;
    //	private Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> extendedProperties;
    private int transactionId;
    private boolean hasError;
    //private TransactionValidateResult transactionValidateResult;
    private List<SecurityDevice> transactionDevicesAvailable;

    public final String getBackendCode() {
        return backendCode;
    }

    public final void setBackendCode(String value) {
        backendCode = value;
    }

    public final String getBackendReference() {
        return backendReference;
    }

    public final void setBackendReference(String value) {
        backendReference = value;
    }

    public final String getBackendMessage() {
        return backendMessage;
    }

    public final void setBackendMessage(String value) {
        backendMessage = value;
    }

    public final boolean getBackendIsError() {
        return backendIsError;
    }

    public final void setBackendIsError(boolean value) {
        backendIsError = value;
    }

//	public final Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> getExtendedProperties() { return extendedProperties; }
//	public final void setExtendedProperties(Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> value) { extendedProperties = value; }

    public final int getTransactionId() {
        return transactionId;
    }

    public final void setTransactionId(int value) {
        transactionId = value;
    }

    public final boolean getHasError() {
        return hasError;
    }

    public final void setHasError(boolean value) {
        hasError = value;
    }

// 	public final TransactionValidateResult getTransactionValidateResult() { return transactionValidateResult; }
//	public final void setTransactionValidateResult(TransactionValidateResult value) { transactionValidateResult = value; }

    public final List<SecurityDevice> getTransactionDevicesAvailable() {
        return transactionDevicesAvailable;
    }

    public final void setTransactionDevicesAvailable(List<SecurityDevice> value) {
        transactionDevicesAvailable = value;
    }
}