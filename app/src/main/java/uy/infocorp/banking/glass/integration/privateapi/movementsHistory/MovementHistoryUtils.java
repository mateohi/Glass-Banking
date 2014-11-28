package uy.infocorp.banking.glass.integration.privateapi.movementsHistory;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.movements.Movement;
import uy.infocorp.banking.glass.util.date.DateUtils;
import uy.infocorp.banking.glass.util.resources.ResourceUtils;

public class MovementHistoryUtils {

    private static final int MOVEMENT_HISTORY_DAYS = ResourceUtils.getInteger(R.integer.movement_history_days);
    private static final int MOVEMENT_HISTORY_HOURS = (int) TimeUnit.DAYS.toHours(MOVEMENT_HISTORY_DAYS);
    private static final int MAX_MOVEMENT_LENGTH = ResourceUtils.getInteger(R.integer.movement_max_history_length);
    ;

    public static String buildFormattedUrl() {
        DateTime now = new DateTime();
        DateTime daysAgo = now.minusHours(MOVEMENT_HISTORY_HOURS);

        String fromDate = DateUtils.dateTimeToIsoString(daysAgo);
        String toDate = DateUtils.dateTimeToIsoString(now);

        return String.format(PrivateUrls.GET_ACCOUNTS_MOVEMENTS_URL, fromDate, toDate);
    }

    public static List<Movement> getCorrectedMovements(Movement[] movements) {
        if (movements.length > MAX_MOVEMENT_LENGTH) {
            movements = Arrays.copyOf(movements, MAX_MOVEMENT_LENGTH);
        }

        return Arrays.asList(movements);
    }
}
