package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

import java.util.List;
import java.util.Map;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.authorization.Feature;

public class Product {
    private int productId;
    private String productBankIdentifier;
    private String productNumber;
    private String productAlias;
    //private ProductType productType;
    private String productOwnerName;
    private String productBranchName;
    private int clientId;
    //private Currency currency;
    private List<Feature> features;
    //private ProductStatus productStatus;
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

/*  public final ProductType getProductType() { return productType; }
    public final void setProductType(ProductType value) { productType = value; } */

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

    /*  public final Currency getCurrency() { return currency; }
        public final void setCurrency(Currency value) { currency = value; }
    */
    public final List<Feature> getFeatures() {
        return features;
    }

    public final void setFeatures(List<Feature> value) {
        features = value;
    }

/*
	public final ProductStatus getProductStatus() { return productStatus; }
	public final void setProductStatus(ProductStatus value) { productStatus = value; }
*/

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
}