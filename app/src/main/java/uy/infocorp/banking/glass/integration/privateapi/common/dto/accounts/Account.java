package uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class Account extends Product
{
	//private Infocorp.Framework.BusinessEntities.Common.Bank accountBank;
	private String accountOfficerName;
	private java.math.BigDecimal accountCountableBalance = new java.math.BigDecimal(0);
	private java.math.BigDecimal accountAvailableBalance = new java.math.BigDecimal(0);
	private java.math.BigDecimal accountBalance24Hrs = new java.math.BigDecimal(0);
	private java.math.BigDecimal accountBalance48Hrs = new java.math.BigDecimal(0);
	private java.math.BigDecimal accountBalance48MoreHrs = new java.math.BigDecimal(0);
	private java.math.BigDecimal monthlyAverageBalance = new java.math.BigDecimal(0);
	private int pendingChecks;
	private int checksToReleaseToday;
	private int checksToReleaseTomorrow;
	private int cancelledChecks;
	private int certifiedChecks;
	private int rejectedChecks;
	private java.math.BigDecimal blockedAmount = new java.math.BigDecimal(0);
	private int movementsOfTheMonth;
	private int checksDrawn;
	private java.math.BigDecimal overdrafts = new java.math.BigDecimal(0);

/*	public final Infocorp.Framework.BusinessEntities.Common.Bank getAccountBank() { return accountBank; }
	public final void setAccountBank(Infocorp.Framework.BusinessEntities.Common.Bank value) { accountBank = value; }
	*/

	public final String getAccountOfficerName()
	{
		return accountOfficerName;
	}
	public final void setAccountOfficerName(String value)
	{
		accountOfficerName = value;
	}

	public final java.math.BigDecimal getAccountCountableBalance()
	{
		return accountCountableBalance;
	}
	public final void setAccountCountableBalance(java.math.BigDecimal value){ accountCountableBalance = value; }

	public final java.math.BigDecimal getAccountAvailableBalance()
	{
		return accountAvailableBalance;
	}
	public final void setAccountAvailableBalance(java.math.BigDecimal value) { accountAvailableBalance = value; }

	public final java.math.BigDecimal getAccountBalance24Hrs()
	{
		return accountBalance24Hrs;
	}
	public final void setAccountBalance24Hrs(java.math.BigDecimal value) { accountBalance24Hrs = value; }

	public final java.math.BigDecimal getAccountBalance48Hrs()
	{
		return accountBalance48Hrs;
	}
	public final void setAccountBalance48Hrs(java.math.BigDecimal value) { accountBalance48Hrs = value; }

	public final java.math.BigDecimal getAccountBalance48MoreHrs()
	{
		return accountBalance48MoreHrs;
	}
	public final void setAccountBalance48MoreHrs(java.math.BigDecimal value) { accountBalance48MoreHrs = value; }

	public final java.math.BigDecimal getMonthlyAverageBalance()
	{
		return monthlyAverageBalance;
	}
	public final void setMonthlyAverageBalance(java.math.BigDecimal value) { monthlyAverageBalance = value; }

	public final int getPendingChecks()
	{
		return pendingChecks;
	}
	public final void setPendingChecks(int value)
	{
		pendingChecks = value;
	}

	public final int getChecksToReleaseToday()
	{
		return checksToReleaseToday;
	}
	public final void setChecksToReleaseToday(int value)
	{
		checksToReleaseToday = value;
	}

	public final int getChecksToReleaseTomorrow()
	{
		return checksToReleaseTomorrow;
	}
	public final void setChecksToReleaseTomorrow(int value)
	{
		checksToReleaseTomorrow = value;
	}

	public final int getCancelledChecks()
	{
		return cancelledChecks;
	}
	public final void setCancelledChecks(int value)
	{
		cancelledChecks = value;
	}

	public final int getCertifiedChecks()
	{
		return certifiedChecks;
	}
	public final void setCertifiedChecks(int value)
	{
		certifiedChecks = value;
	}

	public final int getRejectedChecks()
	{
		return rejectedChecks;
	}
	public final void setRejectedChecks(int value)
	{
		rejectedChecks = value;
	}

	public final java.math.BigDecimal getBlockedAmount()
	{
		return blockedAmount;
	}
	public final void setBlockedAmount(java.math.BigDecimal value)
	{
		blockedAmount = value;
	}

	public final int getMovementsOfTheMonth()
	{
		return movementsOfTheMonth;
	}
	public final void setMovementsOfTheMonth(int value)
	{
		movementsOfTheMonth = value;
	}

	public final int getChecksDrawn()
	{
		return checksDrawn;
	}
	public final void setChecksDrawn(int value)
	{
		checksDrawn = value;
	}

	public final java.math.BigDecimal getOverdrafts()
	{
		return overdrafts;
	}
	public final void setOverdrafts(java.math.BigDecimal value)
	{
		overdrafts = value;
	}
}