package uy.infocorp.banking.glass.integration.privateapi.common.dto.loans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.ExtendedPropertyValue;

public class LoanFee {

    private int feeNumber;
    private BigDecimal principalAmount = new BigDecimal(0);
    private Date dueDate = Constants.DATE_MIN_VALUE;
    private BigDecimal interestAmount = new BigDecimal(0);
    private BigDecimal overdueAmount = new BigDecimal(0);
    private BigDecimal othersAmount = new BigDecimal(0);
    private BigDecimal capitalBalance = new BigDecimal(0);
    private Map<String, ExtendedPropertyValue> extendedProperties;
    private LoanStatus privateFeeStatus;

    public final int getFeeNumber() {
        return feeNumber;
    }

    public final void setFeeNumber(int value) {
        feeNumber = value;
    }

    public final BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    public final void setPrincipalAmount(BigDecimal value) {
        principalAmount = value;
    }

    public final Date getDueDate() {
        return dueDate;
    }

    public final void setDueDate(Date value) {
        dueDate = value;
    }

    public final BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public final void setInterestAmount(BigDecimal value) {
        interestAmount = value;
    }

    public final BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public final void setOverdueAmount(BigDecimal value) {
        overdueAmount = value;
    }

    public final BigDecimal getOthersAmount() {
        return othersAmount;
    }

    public final void setOthersAmount(BigDecimal value) {
        othersAmount = value;
    }

    public final BigDecimal getCapitalBalance() {
        return capitalBalance;
    }

    public final void setCapitalBalance(BigDecimal value) {
        capitalBalance = value;
    }

    public final Map<String, ExtendedPropertyValue> getExtendedProperties() {
        return extendedProperties;
    }

    public final void setExtendedProperties(Map<String, ExtendedPropertyValue> value) {
        extendedProperties = value;
    }

    public final LoanStatus getFeeStatus() {
        return privateFeeStatus;
    }

    public final void setFeeStatus(LoanStatus value) {
        privateFeeStatus = value;
    }
}