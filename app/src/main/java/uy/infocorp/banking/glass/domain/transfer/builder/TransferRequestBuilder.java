package uy.infocorp.banking.glass.domain.transfer.builder;

import java.math.BigDecimal;
import java.util.Date;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Currency;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Product;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.integration.privateapi.transfer.dto.request.TransferRequest;
import uy.infocorp.banking.glass.util.resources.Resources;

public class TransferRequestBuilder {

    public static TransferRequest betweenOwnAccounts(int amount, Product debit, Product credit) {
        // FIXME arreglar bien como se llena
        Currency currency = new Currency();
        currency.setCurrencyId(Resources.getString(R.string.alpha_code));

        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.valueOf(amount));
//        transfer.setAuthenticationResponse(null);
//        transfer.setBackendCode(null);
//        transfer.setBackendMessage(null);
//        transfer.setBackendReference(null);
//        transfer.setChannelId((byte) 0);
//        transfer.setCheckSumData(null);
//        transfer.setClientBankIdentifier(null);
//        transfer.setClientId(0);
//        transfer.setComments(null);
//        transfer.setCreatedDate(new Date());
//        transfer.setCreditThirdPartyAccountId(0);
        transfer.setCurrency(currency);
        transfer.setDescription(null);
//        transfer.setExchangeRateTransaction(null);
//        transfer.setExchangeRateUSD(null);
//        transfer.setExecutionDate(null);
//        transfer.setExtendedProperties(null);
//        transfer.setFeature(null);
        transfer.setNotifyTo(null);
//        transfer.setScheduledTransactionId(null);
//        transfer.setSignData(null);
//        transfer.setSiteId(0);
//        transfer.setTransactionAuthenticationDevice(null);
//        transfer.setTransactionId(0);
//        transfer.setTransactionStatus(null);
//        transfer.setUserId(0);
//        transfer.setValueDate(null);

        transfer.setDebitProduct(debit);
        transfer.setCreditProduct(credit);


        TransferRequest request = new TransferRequest();
        request.setTransfer(transfer);

        return request;
    }

}
