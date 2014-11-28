package uy.infocorp.banking.glass.integration.privateapi.transfersHistory.dto;

import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;

/**
 * Created by german on 20/11/2014.
 */
public class TransferHistoryResponseDTO {

    private Transfer[] items;
    private String count;

    public Transfer[] getItems() {
        return items;
    }

    public void setItems(Transfer[] items) {
        this.items = items;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
