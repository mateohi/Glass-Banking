package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.transactions;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.authorization.Feature;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Currency;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.security.SecurityDevice;

public class Transaction {

    private int transactionId;
    private int userId;
    private int clientId;
    private String clientBankIdentifier;
    private Product debitProduct;
    private Product creditProduct;
    private Integer creditThirdPartyAccountId;
    private Date createdDate = Constants.DATE_MIN_VALUE;
    private Date valueDate;
    private Date executionDate;
    private BigDecimal amount;
    private String description;
    private String notifyTo;
    //	private NotificationChannel notificationChannel;
    private TransactionStatus transactionStatus;
    //   private TransactionType transactionType;
    //   private SubTransactionType subTransactionType;
    private Currency currency;
    private Integer scheduledTransactionId;
    //    private TransactionSource transactionSource;
    private String backendCode;
    private String backendReference;
    private String backendMessage;
    private List<String> authenticationResponse;
    private Feature feature;
    private SecurityDevice transactionAuthenticationDevice;
    private BigDecimal exchangeRateTransaction = new BigDecimal(0);
    private BigDecimal exchangeRateUSD = new BigDecimal(0);
    private String comments;
    private String signData;
    private String checkSumData;
//    private ScheduledTransactionStatus scheduledTransactionStatus;

    private byte channelId;
    private int siteId;
    private Map<String, Object> extendedProperties;

    public final int getTransactionId() {
        return transactionId;
    }

    public final void setTransactionId(int value) {
        transactionId = value;
    }

    public final int getUserId() {
        return userId;
    }

    public final void setUserId(int value) {
        userId = value;
    }

    public final int getClientId() {
        return clientId;
    }

    public final void setClientId(int value) {
        clientId = value;
    }

    public final String getClientBankIdentifier() {
        return clientBankIdentifier;
    }

    public final void setClientBankIdentifier(String value) {
        clientBankIdentifier = value;
    }

    public final Product getDebitProduct() {
        return debitProduct;
    }

    public final void setDebitProduct(Product value) {
        debitProduct = value;
    }

    public final Product getCreditProduct() {
        return creditProduct;
    }

    public final void setCreditProduct(Product value) {
        creditProduct = value;
    }

    public final Integer getCreditThirdPartyAccountId() {
        return creditThirdPartyAccountId;
    }

    public final void setCreditThirdPartyAccountId(Integer value) {
        creditThirdPartyAccountId = value;
    }

    public final Date getCreatedDate() {
        return createdDate;
    }

    public final void setCreatedDate(Date value) {
        createdDate = value;
    }

    public final Date getValueDate() {
        return valueDate;
    }

    public final void setValueDate(Date value) {
        valueDate = value;
    }

    public final Date getExecutionDate() {
        return executionDate;
    }

    public final void setExecutionDate(Date value) {
        executionDate = value;
    }

    public final BigDecimal getAmount() {
        return amount;
    }

    public final void setAmount(BigDecimal value) {
        amount = value;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String value) {
        description = value;
    }

    public final String getNotifyTo() {
        return notifyTo;
    }

    public final void setNotifyTo(String value) {
        notifyTo = value;
    }

//    public final NotificationChannel getNotificationChannel() { return notificationChannel; }
//    public final void setNotificationChannel(NotificationChannel value) { notificationChannel = value; }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
//    public final TransactionType getTransactionType() { return transactionType; }
//    public final void setTransactionType(TransactionType value) { transactionType = value; }

//    public final SubTransactionType getSubTransactionType() { return subTransactionType; }
//    public final void setSubTransactionType(SubTransactionType value) { subTransactionType = value; }

    public final Currency getCurrency() {
        return currency;
    }

    public final void setCurrency(Currency value) {
        currency = value;
    }

    public final Integer getScheduledTransactionId() {
        return scheduledTransactionId;
    }

    public final void setScheduledTransactionId(Integer value) {
        scheduledTransactionId = value;
    }

//    public final TransactionSource getTransactionSource() { return transactionSource; }
//    public final void setTransactionSource(TransactionSource value) { transactionSource = value; }

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

    public final List<String> getAuthenticationResponse() {
        return authenticationResponse;
    }

    public final void setAuthenticationResponse(List<String> value) {
        authenticationResponse = value;
    }

    public final Feature getFeature() {
        return feature;
    }

    public final void setFeature(Feature value) {
        feature = value;
    }

    public final SecurityDevice getTransactionAuthenticationDevice() {
        return transactionAuthenticationDevice;
    }

    public final void setTransactionAuthenticationDevice(SecurityDevice value) {
        transactionAuthenticationDevice = value;
    }

    public final BigDecimal getExchangeRateTransaction() {
        return exchangeRateTransaction;
    }

    public final void setExchangeRateTransaction(java.math.BigDecimal value) {
        exchangeRateTransaction = value;
    }

    public final BigDecimal getExchangeRateUSD() {
        return exchangeRateUSD;
    }

    public final void setExchangeRateUSD(BigDecimal value) {
        exchangeRateUSD = value;
    }

    public final String getComments() {
        return comments;
    }

    public final void setComments(String value) {
        comments = value;
    }

    public final String getSignData() {
        return signData;
    }

    public final void setSignData(String value) {
        signData = value;
    }

    public final String getCheckSumData() {
        return checkSumData;
    }

    public final void setCheckSumData(String value) {
        checkSumData = value;
    }

//    public final ScheduledTransactionStatus getScheduledTransactionStatus() { return scheduledTransactionStatus; }
//    public final void setScheduledTransactionStatus(ScheduledTransactionStatus value) { scheduledTransactionStatus = value; }

    public final byte getChannelId() {
        return channelId;
    }

    public final void setChannelId(byte value) {
        channelId = value;
    }

    public final int getSiteId() {
        return siteId;
    }

    public final void setSiteId(int value) {
        siteId = value;
    }

    public final Map<String, Object> getExtendedProperties() {
        return extendedProperties;
    }

    public final void setExtendedProperties(Map<String, Object> value) {
        extendedProperties = value;
    }
}