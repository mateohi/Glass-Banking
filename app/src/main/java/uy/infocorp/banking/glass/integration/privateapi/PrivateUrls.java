package uy.infocorp.banking.glass.integration.privateapi;

import uy.infocorp.banking.glass.R;

public class PrivateUrls {

    private static final String SERVICE_HOST = "http://66.231.249.217";
    private static final String SERVICE_PATH = "/Santander.Banking.WebApi/api";
    private static final String BASE_URL = SERVICE_HOST + SERVICE_PATH;

    /**
     * Sign in
     */
    public static final String POST_SIGN_IN_URL = BASE_URL + "/administration/general/signIn";
    /**
     * Validate Security Device (Sign in second factor of validation)
     */
    public static final String POST_VALIDATE_SECURITY_DEVICE_URL = BASE_URL + "/framework/authentication/validateSecurityDevice";

    /**
     * Get Consolidated Position Data
     */
    public static final String GET_CONSOLIDATED_POSITION_URL = BASE_URL + "/administration/users/products";

    /**
     * Get Inbox Messages
     */
    public static final String GET_INBOX_MESSAGES_URL = BASE_URL + "/framework/messaging";
    /**
     * Get third party accounts within the same bank
     */
    public static final String GET_THIRDPARTY_ACCOUNTS_LOCAL_URL = BASE_URL + "/accounts/thirdPartyAccounts/local";
    /**
     * Get third party accounts in country
     */
    public static final String GET_THIRDPARTY_ACCOUNTS_INCOUNTRY_URL = BASE_URL + "/accounts/thirdPartyAccounts/country";
    /**
     * Get Transfers History
     */
//  public static final String GET_TRANSFERS_HISTORY_URL = BASE_URL + "/transfers/transfers?dateFrom=2014‐09‐01T03:00:00.000Z&dateTo=2014‐09‐30T02:59:59.999Z";
    public static final String GET_TRANSFERS_HISTORY_URL = BASE_URL + "/transfers/transfers?dateFrom=%s&dateTo=%s";
    /**
     * Get Service Payments
     */
    public static final String GET_SERVICE_PAYMENTS_URL = BASE_URL + "/api/servicePayments/servicePayments/entities";

    /**
     * Get Acounts Movements
     */
    //ToDO: Change parameters
    public static final String GET_ACCOUNTS_MOVEMENTS_URL = BASE_URL + "/accounts/accounts/1%7C003107442811%7CDDA/movements?dateFrom=%s&dateTo=%s";
//    public static final String GET_ACCOUNTS_MOVEMENTS_URL = BASE_URL + "/accounts/accounts/1%7C003107442811%7CDDA/movements?dateFrom=2014‐09‐01T03:00:00.000Z&dateTo=2014‐09‐30T02:59:59.999Z";
    /**
     * Get Credit Cards Movements
     */
    //ToDO: Change parameters
    public static final String GET_CREDIT_CARDS_MOVEMENTS_URL = BASE_URL + "/creditCards/creditCards/6%7C00040001400000296660%7C%7C5414800091043440/movements?dateFrom=%s&dateTo=%s";
//    public static final String GET_CREDIT_CARDS_MOVEMENTS_URL = BASE_URL + "/creditCards/creditCards/6%7C00040001400000296660%7C%7C5414800091043440/movements?dateFrom=2014‐09‐01T03:00:00.000Z&dateTo=2014‐09‐30T02:59:59.999Z";

    /**
     * Post Transfer from Own Account
     */
    public static final String POST_TRANSFER_FROM_OWN_ACCOUNT_URL = BASE_URL + "/transfers/transfers/ownAccounts";

}
