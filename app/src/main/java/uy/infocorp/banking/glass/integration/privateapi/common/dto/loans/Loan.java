package uy.infocorp.banking.glass.integration.privateapi.common.dto.loans;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.Account;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class Loan extends Product
{
	private java.math.BigDecimal originalAmount = new java.math.BigDecimal(0);
	private java.math.BigDecimal payoffBalance = new java.math.BigDecimal(0);
	private java.math.BigDecimal currentRate = new java.math.BigDecimal(0);
	private int term;
	private int paidFees;
	private Account account;
	private java.math.BigDecimal currentBalance = new java.math.BigDecimal(0);
//	private LoanFee nextFee;
	private java.math.BigDecimal prepaymentAmount = new java.math.BigDecimal(0);
	private int feesDue;
	private java.math.BigDecimal feesDuePrincipalAmount = new java.math.BigDecimal(0);
	private java.math.BigDecimal feesDueInterestAmount = new java.math.BigDecimal(0);
	private java.math.BigDecimal feesDueOverdueAmount = new java.math.BigDecimal(0);
	private java.math.BigDecimal feesDueOthersAmount = new java.math.BigDecimal(0);
	private int overdueDays;
//	private LoanStatus loanStatus;

	public final java.math.BigDecimal getOriginalAmount()
	{
		return originalAmount;
	}
	public final void setOriginalAmount(java.math.BigDecimal value)
	{
		originalAmount = value;
	}

	public final java.math.BigDecimal getPayoffBalance()
	{
		return payoffBalance;
	}
	public final void setPayoffBalance(java.math.BigDecimal value)
	{
		payoffBalance = value;
	}

	public final java.math.BigDecimal getCurrentRate()
	{
		return currentRate;
	}
	public final void setCurrentRate(java.math.BigDecimal value)
	{
		currentRate = value;
	}

	public final int getTerm()
	{
		return term;
	}
	public final void setTerm(int value)
	{
		term = value;
	}

	public final int getPaidFees()
	{
		return paidFees;
	}
	public final void setPaidFees(int value)
	{
		paidFees = value;
	}

	public final Account getAccount()
	{
		return account;
	}
	public final void setAccount(Account value)
	{
		account = value;
	}

	public final java.math.BigDecimal getCurrentBalance()
	{
		return currentBalance;
	}
	public final void setCurrentBalance(java.math.BigDecimal value)
	{
		currentBalance = value;
	}

/*	public final LoanFee getNextFee() { return nextFee; }
	public final void setNextFee(LoanFee value) { nextFee = value; }
*/
	public final java.math.BigDecimal getPrepaymentAmount()
	{
		return prepaymentAmount;
	}
	public final void setPrepaymentAmount(java.math.BigDecimal value)
	{
		prepaymentAmount = value;
	}

	public final int getFeesDue()
	{
		return feesDue;
	}
	public final void setFeesDue(int value)
	{
		feesDue = value;
	}

	public final java.math.BigDecimal getFeesDuePrincipalAmount()
	{
		return feesDuePrincipalAmount;
	}
	public final void setFeesDuePrincipalAmount(java.math.BigDecimal value) { feesDuePrincipalAmount = value; }

	public final java.math.BigDecimal getFeesDueInterestAmount()
	{
		return feesDueInterestAmount;
	}
	public final void setFeesDueInterestAmount(java.math.BigDecimal value) { feesDueInterestAmount = value; }

	public final java.math.BigDecimal getFeesDueOverdueAmount()
	{
		return feesDueOverdueAmount;
	}
	public final void setFeesDueOverdueAmount(java.math.BigDecimal value) { feesDueOverdueAmount = value; }

	public final java.math.BigDecimal getFeesDueOthersAmount()
	{
		return feesDueOthersAmount;
	}
	public final void setFeesDueOthersAmount(java.math.BigDecimal value) { feesDueOthersAmount = value; }

	public final int getOverdueDays()
	{
		return overdueDays;
	}
	public final void setOverdueDays(int value)
	{
		overdueDays = value;
	}

/*  public final LoanStatus getLoanStatus() { return loanStatus; }
	public final void setLoanStatus(LoanStatus value) { loanStatus = value; }
*/
}