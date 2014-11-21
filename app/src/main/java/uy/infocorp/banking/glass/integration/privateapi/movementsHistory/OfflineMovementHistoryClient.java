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
        return "{" +
                "    \"items\": [{" +
                "        \"id\": 1546597236," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-24T02:00:00Z\"," +
                "        \"amount\": 10.00," +
                "        \"isDebit\": false," +
                "        \"balance\": 4583.73," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PR                 REF:    025052 - ADEL TRANS INTERNET MC\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013275\"," +
                "            \"reference\": \"P0012014-10-24145250\"" +
                "        }" +
                "    }, {" +
                "        \"id\": -1400285249," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-24T02:00:00Z\"," +
                "        \"amount\": 500.00," +
                "        \"isDebit\": false," +
                "        \"balance\": 4573.73," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PR                 REF:    084152 - ADEL TRANS INTERNET MC\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013274\"," +
                "            \"reference\": \"P0012014-10-24141841\"" +
                "        }" +
                "    }, {" +
                "        \"id\": -1007513785," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-24T02:00:00Z\"," +
                "        \"amount\": 100.00," +
                "        \"isDebit\": false," +
                "        \"balance\": 4073.73," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PR                 REF:    052552 - ADEL TRANS INTERNET MC\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013273\"," +
                "            \"reference\": \"P0012014-10-24141525\"" +
                "        }" +
                "    }, {" +
                "        \"id\": -2135749190," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-24T02:00:00Z\"," +
                "        \"amount\": 8.00," +
                "        \"isDebit\": false," +
                "        \"balance\": 3973.73," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \" INTER. TRANS:  ********0067 - 102414103820\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013272\"," +
                "            \"reference\": \"P0012014-10-2400000000\"" +
                "        }" +
                "    }, {" +
                "        \"id\": -1562555299," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-22T02:00:00Z\"," +
                "        \"amount\": 44.44," +
                "        \"isDebit\": false," +
                "        \"balance\": 3965.73," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PAGO EXPRESS003103585448 - P1429500005\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013271\"," +
                "            \"reference\": \"P0012014-10-2200000000\"" +
                "        }" +
                "    }, {" +
                "        \"id\": -490866306," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-22T02:00:00Z\"," +
                "        \"amount\": -77.41," +
                "        \"isDebit\": false," +
                "        \"balance\": 3921.29," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PAGO EXPRESS009001000583 - P1429500005 ARIYUZEC PEXCUB TE POUCEI SOCIEDAD ESPANOLA DE AU\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013270\"," +
                "            \"reference\": \"P0012014-10-2200000000\"" +
                "        }" +
                "    }, {" +
                "        \"id\": -798427632," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-22T02:00:00Z\"," +
                "        \"amount\": -87.47," +
                "        \"isDebit\": false," +
                "        \"balance\": 3998.70," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PAGO EXPRESS009001000583 - P1429500005 E cabrera JCPenney 45496859755\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013269\"," +
                "            \"reference\": \"P0012014-10-2200000000\"" +
                "        }" +
                "    }, {" +
                "        \"id\": 273261361," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-22T02:00:00Z\"," +
                "        \"amount\": -114.78," +
                "        \"isDebit\": false," +
                "        \"balance\": 4086.17," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PAGO EXPRESS009001000591 - P1429500005 ARIYUZEC PEXCUB TE POUCEI FirstBank (Pr&#233;stamos Pe\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013268\"," +
                "            \"reference\": \"P0012014-10-2200000000\"" +
                "        }" +
                "    }, {" +
                "        \"id\": -1743116074," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-22T02:00:00Z\"," +
                "        \"amount\": -56.24," +
                "        \"isDebit\": false," +
                "        \"balance\": 4200.95," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PAGO EXPRESS009001000591 - P1429500005 ARIYUZEC PEXCUB TE POUCEI Claro (Telefonia Fija-a\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013267\"," +
                "            \"reference\": \"P0012014-10-2200000000\"" +
                "        }" +
                "    }, {" +
                "        \"id\": -21862958," +
                "        \"accountId\": 0," +
                "        \"movementDate\": \"2014-10-16T02:00:00Z\"," +
                "        \"amount\": -4.50," +
                "        \"isDebit\": false," +
                "        \"balance\": -72.96," +
                "        \"typeId\": 0," +
                "        \"checkId\": \"\"," +
                "        \"extendedProperties\": {" +
                "            \"observations\": \"PAGO EXPRESS009001000591 - P1428900004 ARIYUZEC PEXCUB TE POUCEI Asistencia En El Hogar\"," +
                "            \"productCode\": \"003106853222\"," +
                "            \"movNumber\": \"000013248\"," +
                "            \"reference\": \"P0012014-10-1600000000\"" +
                "        }" +
                "    }]," +
                "    \"count\": 10" +
                "}\"";
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
