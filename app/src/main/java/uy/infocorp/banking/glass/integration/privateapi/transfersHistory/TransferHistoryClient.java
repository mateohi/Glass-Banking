package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.integration.privateapi.transfersHistory.dto.TransferHistoryResponseDTO;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.ResourceUtils;

public class TransferHistoryClient extends BaseClient {

    private static TransferHistoryClient instance;
    private RestExecutionBuilder builder;
    private String authToken;

    private TransferHistoryClient() {
        builder = RestExecutionBuilder.get();
    }

    public static TransferHistoryClient instance() {
        if (instance == null) {
            instance = new TransferHistoryClient();
        }
        return instance;
    }

    public List<Transfer> getLastTransfers(String authToken) {
        this.authToken = authToken;
        return (List<Transfer>) this.execute();
    }


    @Override
    public Object getOffline() {
        Transfer[] transfers = ResourceUtils.jsonToObject(R.raw.transfers,
                Transfer[].class);
        return Arrays.asList(transfers);
    }

    @Override
    public Object getOnline() {
        String xAuthTokenHeaderName = ResourceUtils.getString(R.string.x_auth_header);
        Header tokenHeader = new BasicHeader(xAuthTokenHeaderName, this.authToken);
        String formattedUrl = TransferHistoryUtils.buildFormattedUrl();
        TransferHistoryResponseDTO transferResponse = this.builder
                .appendUrl(formattedUrl)
                .appendHeader(tokenHeader)
                .execute(TransferHistoryResponseDTO.class);

        Transfer[] transfers = transferResponse.getItems();

        return TransferHistoryUtils.getCorrectedTransfers(transfers);
    }
}
