package uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.ThirdPartyAccount;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.transactions.Transaction;

public class Transfer extends Transaction {

    private ThirdPartyAccount newThirdPartyAccount;

    public final ThirdPartyAccount getNewThirdPartyAccount() {
        return newThirdPartyAccount;
    }

    public final void setNewThirdPartyAccount(ThirdPartyAccount value) {
        newThirdPartyAccount = value;
    }

    /*private int frequencyId;
    private int scheduledTransferStatusId;
    private boolean containsNewBeneficiary;
    private boolean costsChargedToTheBeneficiary;

    public final int getFrequencyId() {
        return frequencyId;
    }

    public final void setFrequencyId(int value) {
        frequencyId = value;
    }

    public final int getScheduledTransferStatusId() {
        return scheduledTransferStatusId;
    }

    public final void setScheduledTransferStatusId(int value) {
        scheduledTransferStatusId = value;
    }

    public final boolean getContainsNewBeneficiary() {
        return containsNewBeneficiary;
    }

    public final void setContainsNewBeneficiary(boolean value) {
        containsNewBeneficiary = value;
    }

    public final boolean getCostsChargedToTheBeneficiary() {
        return costsChargedToTheBeneficiary;
    }

    public final void setCostsChargedToTheBeneficiary(boolean value) {
        costsChargedToTheBeneficiary = value;
    }*/
}