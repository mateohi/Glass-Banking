package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.util.date.DateUtils;
import uy.infocorp.banking.glass.util.http.RestClientBuilder;

public class TransferHistoryClient {

    private static final int MAX_HISTORY_LENGTH = 10;
    private static final int TRANSFER_HISTORY_HOURS = (int) TimeUnit.DAYS.toHours(2);

    private static TransferHistoryClient instance;
    private RestClientBuilder client;

    private TransferHistoryClient() {
        client = new RestClientBuilder();
    }

    public static TransferHistoryClient instance() {
        if (instance == null) {
            instance = new TransferHistoryClient();
        }
        return instance;
    }

    public List<Transfer> getLastTransfers() {
        DateTime now = new DateTime();
        DateTime twoDaysAgo = now.minusHours(TRANSFER_HISTORY_HOURS);

        String fromDate = DateUtils.dateTimeToIsoString(twoDaysAgo);
        String toDate = DateUtils.dateTimeToIsoString(now);

        String formattedUrl = String.format(PrivateUrls.GET_TRANSFERS_HISTORY_URL, fromDate, toDate);

        Transfer[] transfers = this.client.get(formattedUrl).execute(Transfer[].class);

        if (transfers.length > MAX_HISTORY_LENGTH) {
            transfers = Arrays.copyOf(transfers, MAX_HISTORY_LENGTH);
        }

        return Arrays.asList(transfers);
    }

}
