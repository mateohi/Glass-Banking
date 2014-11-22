package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.util.http.HttpUtils;

public class OfflineTransferHistoryClient {

    private static final String OFFLINE_JSON = "";

    public static List<Transfer> getLastTransfers() {
        Transfer[] transfers = HttpUtils.typeFromStringData(OFFLINE_JSON, Transfer[].class);

        return TransferHistoryUtils.getCorrectedTransfers(transfers);
    }
}
