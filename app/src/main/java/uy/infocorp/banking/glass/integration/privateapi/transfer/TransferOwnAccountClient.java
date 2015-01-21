package uy.infocorp.banking.glass.integration.privateapi.transfer;

import org.apache.http.Header;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.transfer.dto.request.TransferRequest;
import uy.infocorp.banking.glass.integration.privateapi.transfer.dto.response.TransferResponse;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.HttpUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class TransferOwnAccountClient extends BaseClient {

    private static TransferOwnAccountClient instance;
    private RestExecutionBuilder builder;

    private TransferRequest transferRequest;
    private String authToken;

    private TransferOwnAccountClient() {
        this.builder = RestExecutionBuilder.post(PrivateUrls.POST_TRANSFER_FROM_OWN_ACCOUNT_URL);
    }

    public static TransferOwnAccountClient instance() {
        if (instance == null) {
            instance = new TransferOwnAccountClient();
        }
        return instance;
    }

    public Boolean makeTransferBetweenOwnAccounts(String authToken, TransferRequest transferRequest) throws UnsupportedEncodingException {
        this.transferRequest = transferRequest;
        this.authToken = authToken;

        return (Boolean) this.execute();
    }

    @Override
    protected Object getOffline() {
        TransferResponse response = Resources.jsonToObject(R.raw.own_accounts_transfer_response,
                TransferResponse.class);
        return response.wasSuccessful();
    }

    @Override
    protected Object getOnline() {
        Header authHeader = HttpUtils.buildTokenHeader(authToken);

        try {
            TransferResponse response = this.builder.appendHeader(authHeader)
                    .appendObjectBody(transferRequest)
                    .execute(TransferResponse.class);

            return response.wasSuccessful();
        } catch (UnsupportedEncodingException e) {
            return false;
        }

    }
}
