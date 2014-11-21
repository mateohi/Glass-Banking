package uy.infocorp.banking.glass.integration.privateapi.transfersHistory;

import android.util.Log;

import com.google.gson.JsonSyntaxException;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.transfers.Transfer;
import uy.infocorp.banking.glass.integration.privateapi.transfersHistory.dto.TransferHistoryResponseDTO;
import uy.infocorp.banking.glass.util.http.HttpUtils;

/**
 * Created by german on 21/11/2014.
 */
public class OfflineTransferHistoryClient {

    private static final String TAG = OfflineTransferHistoryClient.class.getSimpleName();

    private static String getOfflineJson() {
        return "{" +
                "    \"items\": [{" +
                "        \"transactionId\": 63622," +
                "        \"transactionStatus\": \"succeeded\"," +
                "        \"createdDate\": \"2014-10-24T14:38:15.18Z\"," +
                "        \"executionDate\": \"2014-10-24T14:42:12.673Z\"," +
                "        \"amount\": 8.00," +
                "        \"currency\": {" +
                "            \"currencyId\": \"840\"" +
                "        }," +
                "        \"description\": \"Muevo 8\"," +
                "        \"debitProduct\": {" +
                "            \"productId\": 0," +
                "            \"productNumber\": \"003150000067\"," +
                "            \"clientId\": 0," +
                "            \"canTransact\": false," +
                "            \"subsidiaryId\": 0," +
                "            \"backendId\": 0" +
                "        }," +
                "        \"creditProduct\": {" +
                "            \"productId\": 0," +
                "            \"productNumber\": \"003106853222\"," +
                "            \"clientId\": 0," +
                "            \"canTransact\": false," +
                "            \"subsidiaryId\": 0," +
                "            \"backendId\": 0" +
                "        }," +
                "        \"extendedProperties\": {" +
                "            \"backendReference\": 63622" +
                "        }" +
                "    }]," +
                "    \"count\": 1" +
                "}";
    }

    public static List<Transfer> getLastTransfers() throws Exception {
        String data = getOfflineJson();
        try {
            TransferHistoryResponseDTO response = HttpUtils.typeFromStringData(data, TransferHistoryResponseDTO.class);
            Transfer[] transfers = response.getItems();
            return Arrays.asList(transfers);
        } catch (JsonSyntaxException jsonException) {
            Log.e("Error parsing json Response", TAG);
            throw jsonException;
        } catch (Exception e) {
            Log.e("Error parsing json Response", TAG);
            throw e;
        }
    }

}
