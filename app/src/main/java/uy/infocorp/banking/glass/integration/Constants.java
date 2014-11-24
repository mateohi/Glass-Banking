package uy.infocorp.banking.glass.integration;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Constants {

    public static final Date DATE_MIN_VALUE = new Date(Long.MIN_VALUE);
    public static final boolean OFFLINE_MODE = true;
    public static final String X_AUTH_TOKEN_HEADER_NAME = "X-Auth-Token";

    //Transfer History
    public static final int TRANSFER_MAX_HISTORY_LENGTH = 10;
    public static final int TRANSFER_HISTORY_HOURS = (int) TimeUnit.DAYS.toHours(2);

    //Movements History
    public static final int MOVEMENT_MAX_HISTORY_LENGTH = 10;
    public static final int MOVEMENT_HISTORY_HOURS = (int) TimeUnit.DAYS.toHours(2);
    //ToDo: ver como realizar el mapeo (no viene en el json)
    public static final String MOVEMENT_CURRENCY_SYMBOL = "USD";

    //Beacons
    // FIXME cambiar el proximity id por uno de IC, el major por uno del banco
    public static final String BEACONS_IDENTIFIER_ID = "rid";
    public static final String BEACONS_PROXIMITYUID = null;
    public static final Integer BEACONS_MAJOR = null;
    public static final Integer BEACONS_MINOR = null;
}
