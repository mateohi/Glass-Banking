package uy.infocorp.banking.glass.integration.privateapi.common.dto.creditCards;

import java.math.BigDecimal;
import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.Constants;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Currency;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class CreditCard extends Product {

    private Date privateDueDate = Constants.DATE_MIN_VALUE;
    private Date privateCloseDate = Constants.DATE_MIN_VALUE;
    private int privateFatherCreditCardId;
    private int privateCreditCardId;
    private BigDecimal privateLocalBalance = new BigDecimal(0);
    private BigDecimal privateDollarBalance = new BigDecimal(0);
    private BigDecimal privateLocalCreditLimit = new BigDecimal(0);
    private BigDecimal privateDollarCreditLimit = new BigDecimal(0);
    private Currency privateInternationalCurrency;
    private boolean privateHasInternationalCurrency;

    public final Date getDueDate() {
        return privateDueDate;
    }

    public final void setDueDate(Date value) {
        privateDueDate = value;
    }

    public final Date getCloseDate() {
        return privateCloseDate;
    }

    public final void setCloseDate(Date value) {
        privateCloseDate = value;
    }

    public final int getFatherCreditCardId() {
        return privateFatherCreditCardId;
    }

    public final void setFatherCreditCardId(int value) {
        privateFatherCreditCardId = value;
    }

    public final int getCreditCardId() {
        return privateCreditCardId;
    }

    public final void setCreditCardId(int value) {
        privateCreditCardId = value;
    }

    public final BigDecimal getLocalBalance() {
        return privateLocalBalance;
    }

    public final void setLocalBalance(BigDecimal value) {
        privateLocalBalance = value;
    }

    public final BigDecimal getDollarBalance() {
        return privateDollarBalance;
    }

    public final void setDollarBalance(BigDecimal value) {
        privateDollarBalance = value;
    }

    public final BigDecimal getLocalCreditLimit() {
        return privateLocalCreditLimit;
    }

    public final void setLocalCreditLimit(BigDecimal value) {
        privateLocalCreditLimit = value;
    }

    public final BigDecimal getDollarCreditLimit() {
        return privateDollarCreditLimit;
    }

    public final void setDollarCreditLimit(BigDecimal value) {
        privateDollarCreditLimit = value;
    }

    public final Currency getInternationalCurrency() {
        return privateInternationalCurrency;
    }

    public final void setInternationalCurrency(Currency value) {
        privateInternationalCurrency = value;
    }

    public final boolean getHasInternationalCurrency() {
        return privateHasInternationalCurrency;
    }

    public final void setHasInternationalCurrency(boolean value) {
        privateHasInternationalCurrency = value;
    }
}