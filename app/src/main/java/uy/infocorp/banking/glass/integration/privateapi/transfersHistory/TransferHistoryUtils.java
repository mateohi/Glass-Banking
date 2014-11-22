package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.util.date.DateUtils;

public class TransferHistoryUtils {

    private static final int TRANSFER_HISTORY_HOURS = (int) TimeUnit.DAYS.toHours(2);
    private static final int MAX_HISTORY_LENGTH = 10;

    public static String buildFormattedUrl() {
        DateTime now = new DateTime();
        DateTime twoDaysAgo = now.minusHours(TRANSFER_HISTORY_HOURS);

        String fromDate = DateUtils.dateTimeToIsoString(twoDaysAgo);
        String toDate = DateUtils.dateTimeToIsoString(now);

        return String.format(PrivateUrls.GET_TRANSFERS_HISTORY_URL, fromDate, toDate);
    }

    public static List<Transfer> getCorrectedTransfers(Transfer[] transfers) {
        if (transfers.length > MAX_HISTORY_LENGTH) {
            transfers = Arrays.copyOf(transfers, MAX_HISTORY_LENGTH);
        }

        return Arrays.asList(transfers);
    }
}
