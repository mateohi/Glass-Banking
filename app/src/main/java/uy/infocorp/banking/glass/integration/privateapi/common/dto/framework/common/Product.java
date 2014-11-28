package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

import java.util.List;
import java.util.Map;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.Account;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.creditCards.CreditCard;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.creditLines.CreditLine;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.authorization.Feature;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.loans.Loan;

public class Product {

    private int productId;
    private String productBankIdentifier;
    private String productNumber;
    private String productAlias;
    private ProductType productType;
    private String productOwnerName;
    private String productBranchName;
    private int clientId;
    private Currency currency;
    private List<Feature> features;
    private ProductStatus productStatus;
    private Map<String, Object> extendedProperties;
    private boolean canTransact;
    private int subsidiaryId;
    private String subsidiaryName;
    private int backendId;

    public final int getProductId() {
        return productId;
    }

    public final void setProductId(int value) {
        productId = value;
    }

    public final String getProductBankIdentifier() {
        return productBankIdentifier;
    }

    public final void setProductBankIdentifier(String value) {
        productBankIdentifier = value;
    }

    public final String getProductNumber() {
        return productNumber;
    }

    public final void setProductNumber(String value) {
        productNumber = value;
    }

    public final String getProductAlias() {
        return productAlias;
    }

    public final void setProductAlias(String value) {
        productAlias = value;
    }

    public final ProductType getProductType() {
        return productType;
    }

    public final void setProductType(ProductType value) {
        productType = value;
    }

    public final String getProductOwnerName() {
        return productOwnerName;
    }

    public final void setProductOwnerName(String value) {
        productOwnerName = value;
    }

    public final String getProductBranchName() {
        return productBranchName;
    }

    public final void setProductBranchName(String value) {
        productBranchName = value;
    }

    public final int getClientId() {
        return clientId;
    }

    public final void setClientId(int value) {
        clientId = value;
    }

    public final Currency getCurrency() {
        return currency;
    }

    public final void setCurrency(Currency value) {
        currency = value;
    }

    public final List<Feature> getFeatures() {
        return features;
    }

    public final void setFeatures(List<Feature> value) {
        features = value;
    }

    public final ProductStatus getProductStatus() {
        return productStatus;
    }

    public final void setProductStatus(ProductStatus value) {
        productStatus = value;
    }

    public final Map<String, Object> getExtendedProperties() {
        return extendedProperties;
    }

    public final void setExtendedProperties(Map<String, Object> value) {
        extendedProperties = value;
    }

    public final boolean getCanTransact() {
        return canTransact;
    }

    public final void setCanTransact(boolean value) {
        canTransact = value;
    }

    public final int getSubsidiaryId() {
        return subsidiaryId;
    }

    public final void setSubsidiaryId(int value) {
        subsidiaryId = value;
    }

    public final String getSubsidiaryName() {
        return subsidiaryName;
    }

    public final void setSubsidiaryName(String value) {
        subsidiaryName = value;
    }

    public final int getBackendId() {
        return backendId;
    }

    public final void setBackendId(int value) {
        backendId = value;
    }

    public final String getProductTypeDescription(){
        String description = "";
        switch (productType){
            case currentAccount:
                description = "Current Account";
                break;
            case savingsAccount:
                description = "Savings Account";
                break;
            case investment:
                description = "Investment";
                break;
            case creditLine:
                description = "Credit Line";
                break;
            case fixedTermDeposit:
                description = "Fixed Deposit";
                break;
            case creditCard:
                description = "Credit Card";
                break;
            case loan:
                description = "Loan";
                break;
            case undefined://Undefined is mapped with Mortgage
                description = "Mortgage";
                break;
            default:
                throw new IllegalStateException("No se pudo parsear el ProductType del producto");
        }
        return description;
    }

    public final String getConsolidatedPositionBalance(){
        String balance = "";
        switch (productType){
            case currentAccount:
                balance = ((Account)this).getAccountCountableBalance().toString();
                break;
            case savingsAccount:
                balance = ((Account)this).getAccountCountableBalance().toString();
                break;
            case investment:
                balance = ((Account)this).getAccountCountableBalance().toString();
                break;
            case creditLine:
                balance = ((CreditLine)this).getAvailableAmount().toString();
                break;
            case fixedTermDeposit:
                balance = this.getExtendedProperties().get("originalAmount").toString();
                break;
            case creditCard:
                balance = ((CreditCard)this).getDollarBalance().toString();
                break;
            case loan:
                balance = ((Loan)this).getCurrentBalance().toString();
                break;
            case undefined://Undefined is mapped with Mortgage and instantiated with Loan
                balance = ((Loan)this).getCurrentBalance().toString();
                break;
            default:
                throw new IllegalStateException("No se pudo parsear el ProductType del producto");
        }
        return balance;
    }
}