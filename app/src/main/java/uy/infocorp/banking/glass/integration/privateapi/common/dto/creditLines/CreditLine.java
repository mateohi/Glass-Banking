package uy.infocorp.banking.glass.integration.privateapi.common.dto.creditLines;

import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class CreditLine extends Product
{
    private final Date DATE_MIN_VALUE = new Date(Long.MIN_VALUE);

    private Date dueDate = DATE_MIN_VALUE;
	private String revolving;
	private java.math.BigDecimal availableAmount = new java.math.BigDecimal(0);
	private java.math.BigDecimal totalAmount = new java.math.BigDecimal(0);
	private java.math.BigDecimal usedAmount = new java.math.BigDecimal(0);

	public final Date getDueDate() { return dueDate; }
	public final void setDueDate(Date value) { dueDate = value; }

	public final String getRevolving() { return revolving; }
	public final void setRevolving(String value) { revolving = value; }

	public final java.math.BigDecimal getAvailableAmount() { return availableAmount; }
	public final void setAvailableAmount(java.math.BigDecimal value) { availableAmount = value; }

	public final java.math.BigDecimal getTotalAmount() { return totalAmount; }
	public final void setTotalAmount(java.math.BigDecimal value) { totalAmount = value; }

	public final java.math.BigDecimal getUsedAmount() { return usedAmount; }
	public final void setUsedAmount(java.math.BigDecimal value) { usedAmount = value; }

}