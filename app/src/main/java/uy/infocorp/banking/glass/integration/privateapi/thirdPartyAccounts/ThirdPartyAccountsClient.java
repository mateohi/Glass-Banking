package uy.infocorp.banking.glass.integration.privateapi.thirdPartyAccounts;

import java.io.UnsupportedEncodingException;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.offline.OfflineResourceUtils;

public class ThirdPartyAccountsClient {

    private static ThirdPartyAccountsClient instance;
    private RestExecutionBuilder builder;

    private ThirdPartyAccountsClient() {
        builder = RestExecutionBuilder.get();
    }

    public static ThirdPartyAccountsClient instance() {
        if (instance == null) {
            instance = new ThirdPartyAccountsClient();
        }
        return instance;
    }

    public void getThirdPartyAccountsLocal() throws UnsupportedEncodingException {
        if (OfflineResourceUtils.offline()) {
            // TODO cambiar
            OfflineResourceUtils.jsonToObject(R.raw.accounts_local, Object.class);
        }

        //return this.builder.appendUrl(PrivateUrls.GET_THIRDPARTY_ACCOUNTS_LOCAL_URL).execute(Message.class);
    }

    public void getThirdPartyAccountsInCountry() throws UnsupportedEncodingException {
        if (OfflineResourceUtils.offline()) {
            // TODO cambiar
            OfflineResourceUtils.jsonToObject(R.raw.accounts_in_country, Object.class);
        }

        //return this.builder.appendUrl(PrivateUrls.GET_THIRDPARTY_ACCOUNTS_INCOUNTRY_URL).execute(Message.class);
    }

}
