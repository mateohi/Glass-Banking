package uy.infocorp.banking.glass.integration.privateapi;

public class PrivateUrls {

    private static final String SERVICE_HOST = "http://66.231.249.217";
    private static final String SERVICE_PATH = "/Santander.Banking.WebApi/api";
    private static final String BASE_URL = SERVICE_HOST + SERVICE_PATH;

    public static final String POST_SIGN_IN_URL = BASE_URL + "/administration/general/signIn";

    // Validate Security Device (Sign in second factor of validation)
    public static final String POST_VALIDATE_SECURITY_DEVICE_URL = BASE_URL + "/framework/authentication/validateSecurityDeviceSecondStep";

    public static final String GET_CONSOLIDATED_POSITION_URL = BASE_URL + "/administration/users/products";

    // Get Inbox Messages
    // parameter 'top':Corresponds with the quantity of messages we want to get
    public static final String GET_INBOX_MESSAGES_URL = BASE_URL + "/framework/messages?$top=%d";

    // Get third party accounts within the same bank
    public static final String GET_THIRDPARTY_ACCOUNTS_LOCAL_URL = BASE_URL + "/accounts/thirdPartyAccounts/local";

    //Get third party accounts in country
    public static final String GET_THIRDPARTY_ACCOUNTS_INCOUNTRY_URL = BASE_URL + "/accounts/thirdPartyAccounts/country";

    // Get Transfers History
    public static final String GET_TRANSFERS_HISTORY_URL = BASE_URL + "/transfers/transfers?dateFrom=%s&dateTo=%s";

    // Get Service Payments
    public static final String GET_SERVICE_PAYMENTS_URL = BASE_URL + "/servicePayments/servicePayments/entities";

    // Get Account Movements
    // FIXME parametro raro
    public static final String GET_ACCOUNTS_MOVEMENTS_URL = BASE_URL + "/accounts/accounts/1%7C003107442811%7CDDA/movements?dateFrom=%s&dateTo=%s";

    // Get Credit Cards Movements
    // FIXME parametro raro
    public static final String GET_CREDIT_CARDS_MOVEMENTS_URL = BASE_URL + "/creditCards/creditCards/6%7C00040001400000296660%7C%7C5414800091043440/movements?dateFrom=%s&dateTo=%s";

    // Transfer from Own Account
    public static final String POST_TRANSFER_FROM_OWN_ACCOUNT_URL = BASE_URL + "/transfers/transfers/ownAccounts";

    // Transfer from Third Party Account local
    public static final String POST_TRANSFER_THIRD_PARTY_ACCOUNT_LOCAL_URL = BASE_URL + "/transfers/transfers/intraBank";

    // Transfer from Third Party Account in same country and different bank
    public static final String POST_TRANSFER_THIRD_PARTY_ACCOUNT_INCOUNTRY_URL = BASE_URL + "/transfers/transfers/inCountry";

    // Post user arrival at a certain branch
    public static final String POST_BRANCH_ARRIVAL = BASE_URL + "/framework/common/geolocation";
}
