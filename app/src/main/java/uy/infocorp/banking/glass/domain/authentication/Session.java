package uy.infocorp.banking.glass.domain.authentication;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.util.resources.Resources;

public class Session {

    public static final int MAX_TOKEN_TLL = Resources.getInteger(R.integer.max_token_ttl_minutes);
    private static final Minutes MAX_TOKEN_TTL_MINUTES = Minutes.minutes(MAX_TOKEN_TLL);

    private static String authToken;
    private static DateTime lastAuthenticationDate;

    private Session() {
    }

    public static String getAuthToken() {
        if (authToken == null || invalidToken()) {
            authToken = null;
            lastAuthenticationDate = null;
        }

        return authToken;
    }

    public static void setAuthToken(String newAuthToken) {
        authToken = newAuthToken;
        lastAuthenticationDate = new DateTime();
    }

    private static boolean invalidToken() {
        Minutes tokenMinutesLife = Minutes.minutesBetween(lastAuthenticationDate, new DateTime());
        return tokenMinutesLife.isGreaterThan(MAX_TOKEN_TTL_MINUTES);
    }
}
