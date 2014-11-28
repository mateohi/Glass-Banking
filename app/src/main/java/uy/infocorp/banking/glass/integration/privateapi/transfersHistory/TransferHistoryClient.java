package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.integration.privateapi.transfersHistory.dto.TransferHistoryResponseDTO;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.offline.OfflineResourceUtils;

public class TransferHistoryClient {

    private static final String X_AUTH_TOKEN_HEADER_NAME = OfflineResourceUtils.getString(R.string.x_auth_header);

    private static TransferHistoryClient instance;
    private RestExecutionBuilder builder;

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
        if (OfflineResourceUtils.offline()) {
            Transfer[] transfers = OfflineResourceUtils.jsonToObject(R.raw.transfers,
                    Transfer[].class);
            return Arrays.asList(transfers);
        }

        String formattedUrl = TransferHistoryUtils.buildFormattedUrl();
        Header tokenHeader = new BasicHeader(X_AUTH_TOKEN_HEADER_NAME, authToken);

        TransferHistoryResponseDTO transferResponse = this.builder
                .appendUrl(formattedUrl)
                .appendHeader(tokenHeader)
                .execute(TransferHistoryResponseDTO.class);

        Transfer[] transfers = transferResponse.getItems();

        return TransferHistoryUtils.getCorrectedTransfers(transfers);
    }


}
