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

public class TransferThirdPartyAccountClient extends BaseClient { // TODO cambiar a third party

    private static TransferThirdPartyAccountClient instance;
    private RestExecutionBuilder builder;

    private TransferRequest transferRequest;
    private String authToken;

    private TransferThirdPartyAccountClient() {
        this.builder = RestExecutionBuilder.post(PrivateUrls.POST_TRANSFER_THIRD_PARTY_ACCOUNT_LOCAL_URL);
    }

    public static TransferThirdPartyAccountClient instance() {
        if (instance == null) {
            instance = new TransferThirdPartyAccountClient();
        }
        return instance;
    }

    public Boolean makeTransferBetweenOwnAccounts(String authToken, TransferRequest transferRequest) {
        this.transferRequest = transferRequest;
        this.authToken = authToken;

        return (Boolean) this.execute();
    }

    @Override
    protected Object getOffline() {
        TransferResponse response = Resources.jsonToObject(R.raw.third_party_transfer_response,
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
