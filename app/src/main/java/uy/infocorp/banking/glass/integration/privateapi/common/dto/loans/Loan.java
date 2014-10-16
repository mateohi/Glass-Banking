package uy.infocorp.banking.glass.integration.privateapi.common.dto.loans;

import java.math.BigDecimal;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.Account;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class Loan extends Product {
    
    private BigDecimal originalAmount = new BigDecimal(0);
    private BigDecimal payoffBalance = new BigDecimal(0);
    private BigDecimal currentRate = new BigDecimal(0);
    private int term;
    private int paidFees;
    private Account account;
    private BigDecimal currentBalance = new BigDecimal(0);
    //	private LoanFee nextFee;
    private BigDecimal prepaymentAmount = new BigDecimal(0);
    private int feesDue;
    private BigDecimal feesDuePrincipalAmount = new BigDecimal(0);
    private BigDecimal feesDueInterestAmount = new BigDecimal(0);
    private BigDecimal feesDueOverdueAmount = new BigDecimal(0);
    private BigDecimal feesDueOthersAmount = new BigDecimal(0);
    private int overdueDays;
    //	private LoanStatus loanStatus;

    public final BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public final void setOriginalAmount(BigDecimal value) {
        originalAmount = value;
    }

    public final BigDecimal getPayoffBalance() {
        return payoffBalance;
    }

    public final void setPayoffBalance(BigDecimal value) {
        payoffBalance = value;
    }

    public final BigDecimal getCurrentRate() {
        return currentRate;
    }

    public final void setCurrentRate(BigDecimal value) {
        currentRate = value;
    }

    public final int getTerm() {
        return term;
    }

    public final void setTerm(int value) {
        term = value;
    }

    public final int getPaidFees() {
        return paidFees;
    }

    public final void setPaidFees(int value) {
        paidFees = value;
    }

    public final Account getAccount() {
        return account;
    }

    public final void setAccount(Account value) {
        account = value;
    }

    public final BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public final void setCurrentBalance(BigDecimal value) {
        currentBalance = value;
    }

    /*	public final LoanFee getNextFee() { return nextFee; }
        public final void setNextFee(LoanFee value) { nextFee = value; }
    */
    public final BigDecimal getPrepaymentAmount() {
        return prepaymentAmount;
    }

    public final void setPrepaymentAmount(BigDecimal value) {
        prepaymentAmount = value;
    }

    public final int getFeesDue() {
        return feesDue;
    }

    public final void setFeesDue(int value) {
        feesDue = value;
    }

    public final BigDecimal getFeesDuePrincipalAmount() {
        return feesDuePrincipalAmount;
    }

    public final void setFeesDuePrincipalAmount(BigDecimal value) {
        feesDuePrincipalAmount = value;
    }

    public final BigDecimal getFeesDueInterestAmount() {
        return feesDueInterestAmount;
    }

    public final void setFeesDueInterestAmount(BigDecimal value) {
        feesDueInterestAmount = value;
    }

    public final BigDecimal getFeesDueOverdueAmount() {
        return feesDueOverdueAmount;
    }

    public final void setFeesDueOverdueAmount(BigDecimal value) {
        feesDueOverdueAmount = value;
    }

    public final BigDecimal getFeesDueOthersAmount() {
        return feesDueOthersAmount;
    }

    public final void setFeesDueOthersAmount(BigDecimal value) {
        feesDueOthersAmount = value;
    }

    public final int getOverdueDays() {
        return overdueDays;
    }

    public final void setOverdueDays(int value) {
        overdueDays = value;
    }

/*  public final LoanStatus getLoanStatus() { return loanStatus; }
    public final void setLoanStatus(LoanStatus value) { loanStatus = value; }
*/
}