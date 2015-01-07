package uy.infocorp.banking.glass.domain.transfer.builder;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.transfer.dto.request.TransferRequest;

public class TransferRequestBuilder {

    public static TransferRequest betweenOwnAccounts(int amount, Product debit, Product credit) {
        // TODO implementar
        TransferRequest request = new TransferRequest();
        return request;
    }

}
