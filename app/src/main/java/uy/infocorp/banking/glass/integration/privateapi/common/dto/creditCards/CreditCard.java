package uy.infocorp.banking.glass.integration.privateapi.common.dto.creditCards;

import java.math.BigDecimal;
import java.util.Date;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Currency;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class CreditCard extends Product {

    private Date dueDate = Constants.DATE_MIN_VALUE;
    private Date closeDate = Constants.DATE_MIN_VALUE;
    private int fatherCreditCardId;
    private int creditCardId;
    private BigDecimal localBalance = new BigDecimal(0);
    private BigDecimal dollarBalance = new BigDecimal(0);
    private BigDecimal localCreditLimit = new BigDecimal(0);
    private BigDecimal dollarCreditLimit = new BigDecimal(0);
    private Currency internationalCurrency;
    private boolean hasInternationalCurrency;

    public final Date getDueDate() {
        return dueDate;
    }

    public final void setDueDate(Date value) {
        dueDate = value;
    }

    public final Date getCloseDate() {
        return closeDate;
    }

    public final void setCloseDate(Date value) {
        closeDate = value;
    }

    public final int getFatherCreditCardId() {
        return fatherCreditCardId;
    }

    public final void setFatherCreditCardId(int value) {
        fatherCreditCardId = value;
    }

    public final int getCreditCardId() {
        return creditCardId;
    }

    public final void setCreditCardId(int value) {
        creditCardId = value;
    }

    public final BigDecimal getLocalBalance() {
        return localBalance;
    }

    public final void setLocalBalance(BigDecimal value) {
        localBalance = value;
    }

    public final BigDecimal getDollarBalance() {
        return dollarBalance;
    }

    public final void setDollarBalance(BigDecimal value) {
        dollarBalance = value;
    }

    public final BigDecimal getLocalCreditLimit() {
        return localCreditLimit;
    }

    public final void setLocalCreditLimit(BigDecimal value) {
        localCreditLimit = value;
    }

    public final BigDecimal getDollarCreditLimit() {
        return dollarCreditLimit;
    }

    public final void setDollarCreditLimit(BigDecimal value) {
        dollarCreditLimit = value;
    }

    public final Currency getInternationalCurrency() {
        return internationalCurrency;
    }

    public final void setInternationalCurrency(Currency value) {
        internationalCurrency = value;
    }

    public final boolean getHasInternationalCurrency() {
        return hasInternationalCurrency;
    }

    public final void setHasInternationalCurrency(boolean value) {
        hasInternationalCurrency = value;
    }
}