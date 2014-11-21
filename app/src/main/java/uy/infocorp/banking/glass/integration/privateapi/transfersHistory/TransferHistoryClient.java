package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import android.util.Log;

import com.google.gson.JsonSyntaxException;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.integration.privateapi.transfersHistory.dto.TransferHistoryResponseDTO;
import uy.infocorp.banking.glass.util.date.DateUtils;
import uy.infocorp.banking.glass.util.http.HttpUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;

public class TransferHistoryClient {

    private static final String TAG = TransferHistoryClient.class.getSimpleName();

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

    public List<Transfer> getLastTransfers(String authToken) throws Exception {
        if (Constants.OFFLINE_MODE) {//test
            return OfflineTransferHistoryClient.getLastTransfers();
        }

        DateTime now = new DateTime();
        DateTime twoDaysAgo = now.minusHours(Constants.TRANSFER_HISTORY_HOURS);

        String fromDate = DateUtils.dateTimeToIsoString(twoDaysAgo);
        String toDate = DateUtils.dateTimeToIsoString(now);

        String formattedUrl = String.format(PrivateUrls.GET_TRANSFERS_HISTORY_URL, fromDate, toDate);

        Header tokenHeader = new BasicHeader(Constants.X_AUTH_TOKEN_HEADER_NAME, authToken);
        TransferHistoryResponseDTO response = this.builder.appendUrl(formattedUrl).appendHeader(tokenHeader).execute(TransferHistoryResponseDTO.class);
        Transfer[] transfers = response.getItems();

        if (transfers.length > Constants.TRANSFER_MAX_HISTORY_LENGTH) {
            transfers = Arrays.copyOf(transfers, Constants.TRANSFER_MAX_HISTORY_LENGTH);
        }

        return Arrays.asList(transfers);
    }


}
