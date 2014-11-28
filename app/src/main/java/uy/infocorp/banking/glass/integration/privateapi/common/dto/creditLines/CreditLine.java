package uy.infocorp.banking.glass.integration.privateapi.common.dto.creditLines;

import java.math.BigDecimal;
import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class CreditLine extends Product {

    private Date dueDate = new Date(Long.MIN_VALUE);
    private String revolving;
    private BigDecimal availableAmount = new BigDecimal(0);
    private BigDecimal totalAmount = new BigDecimal(0);
    private BigDecimal usedAmount = new BigDecimal(0);

    public final Date getDueDate() {
        return dueDate;
    }

    public final void setDueDate(Date value) {
        dueDate = value;
    }

    public final String getRevolving() {
        return revolving;
    }

    public final void setRevolving(String value) {
        revolving = value;
    }

    public final BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public final void setAvailableAmount(BigDecimal value) {
        availableAmount = value;
    }

    public final BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public final void setTotalAmount(BigDecimal value) {
        totalAmount = value;
    }

    public final BigDecimal getUsedAmount() {
        return usedAmount;
    }

    public final void setUsedAmount(BigDecimal value) {
        usedAmount = value;
    }

}