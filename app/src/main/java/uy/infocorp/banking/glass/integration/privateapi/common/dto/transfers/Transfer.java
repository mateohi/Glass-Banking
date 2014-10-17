package uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.ThirdPartyAccount;

public class Transfer// extends Infocorp.Framework.BusinessEntities.Transactions.Transaction
{
    private int frequencyId;
    private int scheduledTransferStatusId;
    private boolean containsNewBeneficiary;
    private ThirdPartyAccount newThirdPartyAccount;
    private boolean costsChargedToTheBeneficiary;

    /** Frequency identifier
     */
    public final int getFrequencyId() { return frequencyId; }
    public final void setFrequencyId(int value) { frequencyId = value; }

    public final int getScheduledTransferStatusId() { return scheduledTransferStatusId; }
    public final void setScheduledTransferStatusId(int value) { scheduledTransferStatusId = value; }

    public final boolean getContainsNewBeneficiary() { return containsNewBeneficiary; }
    public final void setContainsNewBeneficiary(boolean value) { containsNewBeneficiary = value; }

    public final ThirdPartyAccount getNewThirdPartyAccount() { return newThirdPartyAccount; }
    public final void setNewThirdPartyAccount(ThirdPartyAccount value) { newThirdPartyAccount = value; }

    public final boolean getCostsChargedToTheBeneficiary() { return costsChargedToTheBeneficiary; }
    public final void setCostsChargedToTheBeneficiary(boolean value) { costsChargedToTheBeneficiary = value; }
}