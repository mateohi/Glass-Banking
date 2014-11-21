package uy.infocorp.banking.glass.integration.privateapi.movementsHistory.dto;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;

/**
 * Created by german on 21/11/2014.
 */
public class MovementHistoryResponseDTO {

    private Movement[] items;
    private String count;

    public Movement[] getItems() {
        return items;
    }

    public void setItems(Movement[] items) {
        this.items = items;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
