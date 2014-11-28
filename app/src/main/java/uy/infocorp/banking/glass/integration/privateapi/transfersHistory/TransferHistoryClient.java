package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.offline.OfflineResourceUtils;

public class TransferHistoryClient {

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

    public List<Transfer> getLastTransfers() {
        if (OfflineResourceUtils.offline()) {
            Transfer[] transfers = OfflineResourceUtils.jsonToObject(R.raw.transfers,
                    Transfer[].class);
            return Arrays.asList(transfers);
        }

        String formattedUrl = TransferHistoryUtils.buildFormattedUrl();
        Transfer[] transfers = this.builder.appendUrl(formattedUrl).execute(Transfer[].class);

        return TransferHistoryUtils.getCorrectedTransfers(transfers);
    }

}
