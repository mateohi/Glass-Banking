package uy.infocorp.banking.glass.integration.privateapi.transfer.dto.request;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;

public class TransferRequest {

    private Transfer transfer;

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }
}
