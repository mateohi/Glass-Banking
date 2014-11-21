package uy.infocorp.banking.glass.integration.privateapi.movementsHistory;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;
import uy.infocorp.banking.glass.integration.privateapi.movementsHistory.dto.MovementHistoryResponseDTO;
import uy.infocorp.banking.glass.util.date.DateUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;

/**
 * Created by german on 21/11/2014.
 */
public class MovementHistoryClient {

    private static final String TAG = MovementHistoryClient.class.getSimpleName();

    private static MovementHistoryClient instance;
    private RestExecutionBuilder builder;

    private MovementHistoryClient() {
        builder = RestExecutionBuilder.get();
    }

    public static MovementHistoryClient instance() {
        if (instance == null) {
            instance = new MovementHistoryClient();
        }
        return instance;
    }

    public List<Movement> getLastMovements(String authToken) throws Exception {
        if (Constants.OFFLINE_MODE) {//test
            return OfflineMovementHistoryClient.getLastMovements();
        }

        DateTime now = new DateTime();
        DateTime twoDaysAgo = now.minusHours(Constants.MOVEMENT_HISTORY_HOURS);

        String fromDate = DateUtils.dateTimeToIsoString(twoDaysAgo);
        String toDate = DateUtils.dateTimeToIsoString(now);

        String formattedUrl = String.format(PrivateUrls.GET_ACCOUNTS_MOVEMENTS_URL, fromDate, toDate);

        Header tokenHeader = new BasicHeader(Constants.X_AUTH_TOKEN_HEADER_NAME, authToken);
        MovementHistoryResponseDTO response = this.builder.appendUrl(formattedUrl).appendHeader(tokenHeader).execute(MovementHistoryResponseDTO.class);
        Movement[] movements = response.getItems();

        if (movements.length > Constants.MOVEMENT_MAX_HISTORY_LENGTH) {
            movements = Arrays.copyOf(movements, Constants.MOVEMENT_MAX_HISTORY_LENGTH);
        }

        return Arrays.asList(movements);
    }


}
