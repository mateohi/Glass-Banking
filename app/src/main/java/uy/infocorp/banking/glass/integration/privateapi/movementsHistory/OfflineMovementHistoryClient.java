package uy.infocorp.banking.glass.integration.privateapi.movementsHistory;

import android.util.Log;

import com.google.gson.JsonSyntaxException;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;
import uy.infocorp.banking.glass.integration.privateapi.movementsHistory.dto.MovementHistoryResponseDTO;
import uy.infocorp.banking.glass.util.http.HttpUtils;

/**
 * Created by german on 21/11/2014.
 */
public class OfflineMovementHistoryClient {

    private static final String TAG = OfflineMovementHistoryClient.class.getSimpleName();

    private static String getOfflineJson() {
        return "{    \n" +
                "\"items\": [{        \n" +
                    "\"id\": 1546597236,\n" +
                    "\"accountId\": 0,\n" +
                    "\"movementDate\": \"2014-10-24T02:00:00Z\",\n" +
                    "\"amount\": 10.00,\n" +
                    "\"isDebit\": false,\n" +
                    "\"balance\": 4583.73,\n" +
                    "\"typeId\": 0,\n" +
                    "\"checkId\": \"\",\n" +
                    "\"extendedProperties\": \n" +
                    "{ \"observations\": \"PR                 REF:    025052 - ADEL TRANS INTERNET MC\",                 \"productCode\": \"003106853222\",\n" +
                    "\"movNumber\": \"000013275\",\n" +
                    "\"reference\": \"P0012014-10-24145250\"\n" +
                    "}\n" +
                "}],\n" +
                "    \"count\": 1\n" +
                "}";
    }

    public static List<Movement> getLastMovements() throws Exception {
        String data = getOfflineJson();
        try {
            MovementHistoryResponseDTO response = HttpUtils.typeFromStringData(data, MovementHistoryResponseDTO.class);
            Movement[] movements = response.getItems();
            return Arrays.asList(movements);
        } catch (JsonSyntaxException jsonException) {
            Log.e("Error parsing json Response", TAG);
            throw jsonException;
        } catch (Exception e) {
            Log.e("Error parsing json Response", TAG);
            throw e;
        }
    }
}
