package uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts;

import java.math.BigDecimal;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Bank;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;

public class Account extends Product {

    private Bank accountBank;
    private String accountOfficerName;
    private BigDecimal accountCountableBalance = new BigDecimal(0);
    private BigDecimal accountAvailableBalance = new BigDecimal(0);
    private BigDecimal accountBalance24Hrs = new BigDecimal(0);
    private BigDecimal accountBalance48Hrs = new BigDecimal(0);
    private BigDecimal accountBalance48MoreHrs = new BigDecimal(0);
    private BigDecimal monthlyAverageBalance = new BigDecimal(0);
    private int pendingChecks;
    private int checksToReleaseToday;
    private int checksToReleaseTomorrow;
    private int cancelledChecks;
    private int certifiedChecks;
    private int rejectedChecks;
    private BigDecimal blockedAmount = new BigDecimal(0);
    private int movementsOfTheMonth;
    private int checksDrawn;
    private BigDecimal overdrafts = new BigDecimal(0);

    public final Bank getAccountBank() {
        return accountBank;
    }

    public final void setAccountBank(Bank value) {
        accountBank = value;
    }

    public final String getAccountOfficerName() {
        return accountOfficerName;
    }

    public final void setAccountOfficerName(String value) {
        accountOfficerName = value;
    }

    public final BigDecimal getAccountCountableBalance() {
        return accountCountableBalance;
    }

    public final void setAccountCountableBalance(BigDecimal value) {
        accountCountableBalance = value;
    }

    public final BigDecimal getAccountAvailableBalance() {
        return accountAvailableBalance;
    }

    public final void setAccountAvailableBalance(BigDecimal value) {
        accountAvailableBalance = value;
    }

    public final BigDecimal getAccountBalance24Hrs() {
        return accountBalance24Hrs;
    }

    public final void setAccountBalance24Hrs(BigDecimal value) {
        accountBalance24Hrs = value;
    }

    public final BigDecimal getAccountBalance48Hrs() {
        return accountBalance48Hrs;
    }

    public final void setAccountBalance48Hrs(BigDecimal value) {
        accountBalance48Hrs = value;
    }

    public final BigDecimal getAccountBalance48MoreHrs() {
        return accountBalance48MoreHrs;
    }

    public final void setAccountBalance48MoreHrs(BigDecimal value) {
        accountBalance48MoreHrs = value;
    }

    public final BigDecimal getMonthlyAverageBalance() {
        return monthlyAverageBalance;
    }

    public final void setMonthlyAverageBalance(BigDecimal value) {
        monthlyAverageBalance = value;
    }

    public final int getPendingChecks() {
        return pendingChecks;
    }

    public final void setPendingChecks(int value) {
        pendingChecks = value;
    }

    public final int getChecksToReleaseToday() {
        return checksToReleaseToday;
    }

    public final void setChecksToReleaseToday(int value) {
        checksToReleaseToday = value;
    }

    public final int getChecksToReleaseTomorrow() {
        return checksToReleaseTomorrow;
    }

    public final void setChecksToReleaseTomorrow(int value) {
        checksToReleaseTomorrow = value;
    }

    public final int getCancelledChecks() {
        return cancelledChecks;
    }

    public final void setCancelledChecks(int value) {
        cancelledChecks = value;
    }

    public final int getCertifiedChecks() {
        return certifiedChecks;
    }

    public final void setCertifiedChecks(int value) {
        certifiedChecks = value;
    }

    public final int getRejectedChecks() {
        return rejectedChecks;
    }

    public final void setRejectedChecks(int value) {
        rejectedChecks = value;
    }

    public final BigDecimal getBlockedAmount() {
        return blockedAmount;
    }

    public final void setBlockedAmount(BigDecimal value) {
        blockedAmount = value;
    }

    public final int getMovementsOfTheMonth() {
        return movementsOfTheMonth;
    }

    public final void setMovementsOfTheMonth(int value) {
        movementsOfTheMonth = value;
    }

    public final int getChecksDrawn() {
        return checksDrawn;
    }

    public final void setChecksDrawn(int value) {
        checksDrawn = value;
    }

    public final BigDecimal getOverdrafts() {
        return overdrafts;
    }

    public final void setOverdrafts(BigDecimal value) {
        overdrafts = value;
    }
}