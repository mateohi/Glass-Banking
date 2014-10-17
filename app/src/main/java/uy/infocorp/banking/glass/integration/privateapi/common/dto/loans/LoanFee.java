package uy.infocorp.banking.glass.integration.privateapi.common.dto.loans;

import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.Constants;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.*;

public class LoanFee{

    private int privateFeeNumber;
	public final int getFeeNumber(){ return privateFeeNumber; }
	public final void setFeeNumber(int value){ privateFeeNumber = value; }

	private java.math.BigDecimal privatePrincipalAmount = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getPrincipalAmount(){ return privatePrincipalAmount; }
	public final void setPrincipalAmount(java.math.BigDecimal value){ privatePrincipalAmount = value; }

	private Date privateDueDate = Constants.DATE_MIN_VALUE;
	public final Date getDueDate(){ return  privateDueDate; }
	public final void setDueDate(Date value){ privateDueDate = value; }

	private java.math.BigDecimal privateInterestAmount = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getInterestAmount(){ return  privateInterestAmount; }
	public final void setInterestAmount(java.math.BigDecimal value){ privateInterestAmount = value; }

	private java.math.BigDecimal privateOverdueAmount = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getOverdueAmount(){ return  privateOverdueAmount; }
	public final void setOverdueAmount(java.math.BigDecimal value){ privateOverdueAmount = value; }

	private java.math.BigDecimal privateOthersAmount = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getOthersAmount(){ return  privateOthersAmount; }
	public final void setOthersAmount(java.math.BigDecimal value){privateOthersAmount = value; }

	private java.math.BigDecimal privateCapitalBalance = new java.math.BigDecimal(0);
	public final java.math.BigDecimal getCapitalBalance(){ return  privateCapitalBalance; }
	public final void setCapitalBalance(java.math.BigDecimal value){ privateCapitalBalance = value; }

	private java.util.HashMap<String, ExtendedPropertyValue> privateExtendedProperties;
	public final java.util.HashMap<String, ExtendedPropertyValue> getExtendedProperties(){ return  privateExtendedProperties; }
	public final void setExtendedProperties(java.util.HashMap<String, ExtendedPropertyValue> value){ privateExtendedProperties = value; }

	/*private LoanFeeStatus privateFeeStatus;
	public final LoanFeeStatus getFeeStatus(){ return  privateFeeStatus; }
	public final void setFeeStatus(LoanFeeStatus value){ privateFeeStatus = value; }*/
}