package uy.infocorp.banking.glass.integration.privateapi.common.dto.servicePayments;

import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.Constants;

public class ServicePayment //extends Transaction
{
    private String serviceBillId;
    private int servicePaymentEntityId;
    private String accountIdentifier;
    private Date serviceBillDueDate = Constants.DATE_MIN_VALUE;
    private String serviceBillDescription;
    private boolean allowsPartialPayment;
    //private Frequency frequency;
    private java.math.BigDecimal pendingBillsAmountMaxThreshold = null;

    public final String getServiceBillId() { return serviceBillId; }
    public final void setServiceBillId(String value) { serviceBillId = value; }

    public final int getServicePaymentEntityId() { return servicePaymentEntityId; }
    public final void setServicePaymentEntityId(int value) { servicePaymentEntityId = value; }

    public final String getAccountIdentifier() { return accountIdentifier; }
    public final void setAccountIdentifier(String value) { accountIdentifier = value; }

    public final Date getServiceBillDueDate() { return serviceBillDueDate; }
    public final void setServiceBillDueDate(Date value) { serviceBillDueDate = value; }

    public final String getServiceBillDescription() { return serviceBillDescription; }
    public final void setServiceBillDescription(String value) { serviceBillDescription = value; }

    public final boolean getAllowsPartialPayment() { return allowsPartialPayment; }
    public final void setAllowsPartialPayment(boolean value) { allowsPartialPayment = value; }

//   public final Infocorp.Framework.BusinessEntities.Scheduling.Frequency getFrequency() { return frequency; }
//   public final void setFrequency(Infocorp.Framework.BusinessEntities.Scheduling.Frequency value) { frequency = value; }

    public final java.math.BigDecimal getPendingBillsAmountMaxThreshold() { return pendingBillsAmountMaxThreshold; }
    public final void setPendingBillsAmountMaxThreshold(java.math.BigDecimal value) { pendingBillsAmountMaxThreshold = value; }
}