package uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Bank;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Currency;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.ProductType;

public class ThirdPartyAccount {

    private int thirdPartyAccountId;
    private String thirdPartyAccountNumber;
    //private Infocorp.Accounts.BusinessEntities.ThirdPartyAccounts.ThirdPartyAccountStatus thirdPartyAccountStatus;
    private String alias;
    private Currency currency;
    //private Infocorp.Framework.BusinessEntities.Transactions.SubTransactionTypeEnum transactionSubType;
    private String ownerName;
    //private Country ownerCountry;
    private String ownerEmail;
    private String ownerCity;
    private String ownerAddress;
    private Bank bank;
    private String branch;
    //	private Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> extendedProperties;
    //	private Infocorp.Accounts.BusinessEntities.ThirdPartyAccounts.ThirdPartyAccountType thirdPartyAccountType;
    private Integer ownerDocumentTypeId;
    private String ownerDocumentNumber;
    //	private Infocorp.Framework.BusinessEntities.Common.ProductType productType;
    //	private ThirdPartyAccountAdditionalInfo thirdPartyAccountsAdditionalInfoData;
    private ProductType productType;

    public final int getThirdPartyAccountId() {
        return thirdPartyAccountId;
    }

    public final void setThirdPartyAccountId(int value) {
        thirdPartyAccountId = value;
    }

    public final String getThirdPartyAccountNumber() {
        return thirdPartyAccountNumber;
    }

    public final void setThirdPartyAccountNumber(String value) {
        thirdPartyAccountNumber = value;
    }

//	public final Infocorp.Accounts.BusinessEntities.ThirdPartyAccounts.ThirdPartyAccountStatus getThirdPartyAccountStatus() { return thirdPartyAccountStatus; }
//	public final void setThirdPartyAccountStatus(Infocorp.Accounts.BusinessEntities.ThirdPartyAccounts.ThirdPartyAccountStatus value) { thirdPartyAccountStatus = value; }

    public final String getAlias() {
        return alias;
    }

    public final void setAlias(String value) {
        alias = value;
    }

    public final Currency getCurrency() {
        return currency;
    }

    public final void setCurrency(Currency value) {
        currency = value;
    }

//	public final Infocorp.Framework.BusinessEntities.Transactions.SubTransactionTypeEnum getTransactionSubType() { return transactionSubType; }
//	public final void setTransactionSubType(SubTransactionTypeEnum value){toString() transactionSubType = value;}

    public final String getOwnerName() {
        return ownerName;
    }

    public final void setOwnerName(String value) {
        ownerName = value;
    }

//	public final Infocorp.Framework.BusinessEntities.Common.Country getOwnerCountry() { return ownerCountry; }
//	public final void setOwnerCountry(Infocorp.Framework.BusinessEntities.Common.Country value) { ownerCountry = value; }

    public final String getOwnerEmail() {
        return ownerEmail;
    }

    public final void setOwnerEmail(String value) {
        ownerEmail = value;
    }

    public final String getOwnerCity() {
        return ownerCity;
    }

    public final void setOwnerCity(String value) {
        ownerCity = value;
    }

    public final String getOwnerAddress() {
        return ownerAddress;
    }

    public final void setOwnerAddress(String value) {
        ownerAddress = value;
    }

    public final Bank getBank() {
        return bank;
    }

    public final void setBank(Bank value) {
        bank = value;
    }

    public final String getBranch() {
        return branch;
    }

    public final void setBranch(String value) {
        branch = value;
    }

//	public final Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> getExtendedProperties() { return extendedProperties; }
//	public final void setExtendedProperties(Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> value){ extendedProperties = value; }

//	public final Infocorp.Accounts.BusinessEntities.ThirdPartyAccounts.ThirdPartyAccountType getThirdPartyAccountType() { return thirdPartyAccountType; }
//	public final void setThirdPartyAccountType(Infocorp.Accounts.BusinessEntities.ThirdPartyAccounts.ThirdPartyAccountType value) { thirdPartyAccountType = value; }

    public final Integer getOwnerDocumentTypeId() {
        return ownerDocumentTypeId;
    }

    public final void setOwnerDocumentTypeId(Integer value) {
        ownerDocumentTypeId = value;
    }

    public final String getOwnerDocumentNumber() {
        return ownerDocumentNumber;
    }

    public final void setOwnerDocumentNumber(String value) {
        ownerDocumentNumber = value;
    }

//	public final Infocorp.Framework.BusinessEntities.Common.ProductType getProductType() { return productType; }
//	public final void setProductType(Infocorp.Framework.BusinessEntities.Common.ProductType value) { productType = value; }

//	public final ThirdPartyAccountAdditionalInfo getThirdPartyAccountsAdditionalInfoData() { return thirdPartyAccountsAdditionalInfoData; }
//	public final void setThirdPartyAccountsAdditionalInfoData(ThirdPartyAccountAdditionalInfo value) { thirdPartyAccountsAdditionalInfoData = value; }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getProductIconId() {
        switch (productType) {
            case currentAccount:
                return R.drawable.current_account;
            case savingsAccount:
                return R.drawable.savings_account;
            case investment:
                return R.drawable.investment;
            case creditLine:
                return R.drawable.credit_line;
            case fixedTermDeposit:
                return R.drawable.fixed_deposit;
            case creditCard:
                return R.drawable.credit_card;
            case loan:
                return R.drawable.loan;
            case undefined://Undefined is mapped with Mortgage and instantiated with Loan
                return R.drawable.mortgage;
            default:
                throw new IllegalArgumentException("Undefined product id");
        }
    }
}