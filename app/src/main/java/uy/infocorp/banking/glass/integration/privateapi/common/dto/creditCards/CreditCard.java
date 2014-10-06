package uy.infocorp.banking.glass.integration.privateapi.common.dto.creditCards;

import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Currency;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class CreditCard extends Product
{
    private final Date DATE_MIN_VALUE = new Date(Long.MIN_VALUE);

	private Date privateDueDate = DATE_MIN_VALUE;
    private Date privateCloseDate = DATE_MIN_VALUE;
    private int privateFatherCreditCardId;
    private int privateCreditCardId;
    private java.math.BigDecimal privateLocalBalance = new java.math.BigDecimal(0);
    private java.math.BigDecimal privateDollarBalance = new java.math.BigDecimal(0);
    private java.math.BigDecimal privateLocalCreditLimit = new java.math.BigDecimal(0);
    private java.math.BigDecimal privateDollarCreditLimit = new java.math.BigDecimal(0);
    private Currency privateInternationalCurrency;
    private boolean privateHasInternationalCurrency;

	public final Date getDueDate() { return privateDueDate; }
	public final void setDueDate(Date value) { privateDueDate = value; }

	public final Date getCloseDate() { return privateCloseDate; }
	public final void setCloseDate(Date value) { privateCloseDate = value; }

	public final int getFatherCreditCardId() { return privateFatherCreditCardId; }
	public final void setFatherCreditCardId(int value) { privateFatherCreditCardId = value; }

	public final int getCreditCardId() { return privateCreditCardId; }
	public final void setCreditCardId(int value) { privateCreditCardId = value; }

	public final java.math.BigDecimal getLocalBalance() { return privateLocalBalance; }
	public final void setLocalBalance(java.math.BigDecimal value) { privateLocalBalance = value; }

	public final java.math.BigDecimal getDollarBalance() { return privateDollarBalance; }
	public final void setDollarBalance(java.math.BigDecimal value) { privateDollarBalance = value; }

	public final java.math.BigDecimal getLocalCreditLimit() { return privateLocalCreditLimit; }
	public final void setLocalCreditLimit(java.math.BigDecimal value) { privateLocalCreditLimit = value; }

	public final java.math.BigDecimal getDollarCreditLimit() { return privateDollarCreditLimit; }
	public final void setDollarCreditLimit(java.math.BigDecimal value) { privateDollarCreditLimit = value; }

	public final Currency getInternationalCurrency() { return privateInternationalCurrency; }
	public final void setInternationalCurrency(Currency value) { privateInternationalCurrency = value; }

	public final boolean getHasInternationalCurrency() { return privateHasInternationalCurrency; }
	public final void setHasInternationalCurrency(boolean value) { privateHasInternationalCurrency = value; }
}