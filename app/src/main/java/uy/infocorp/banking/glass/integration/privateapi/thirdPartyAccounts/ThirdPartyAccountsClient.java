package uy.infocorp.banking.glass.integration.privateapi.thirdPartyAccounts;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.util.http.RestClientBuilder;

public class ThirdPartyAccountsClient {

    private static ThirdPartyAccountsClient instance;
    private RestClientBuilder client;

    private ThirdPartyAccountsClient() {
        client = new RestClientBuilder();
    }

    public static ThirdPartyAccountsClient instance() {
        if (instance == null) {
            instance = new ThirdPartyAccountsClient();
        }
        return instance;
    }

    public void getThirdPartyAccountsLocal() throws UnsupportedEncodingException {
//        return this.client.get(PrivateUrls.GET_THIRDPARTY_ACCOUNTS_LOCAL_URL, Message.class);
    }

    public void getThirdPartyAccountsInCountry() throws UnsupportedEncodingException {
//        return this.client.get(PrivateUrls.GET_THIRDPARTY_ACCOUNTS_INCOUNTRY_URL, Message.class);
    }

}
