package uy.infocorp.banking.glass.integration.privateapi.thirdPartyAccounts;

import org.apache.http.Header;

import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.ThirdPartyAccount;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.HttpUtils;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class ThirdPartyAccountsClient extends BaseClient {

    private static ThirdPartyAccountsClient instance;
    private RestExecutionBuilder builder;
    private boolean localThirdPartyAccounts;
    private String authToken;

    private ThirdPartyAccountsClient() {
        builder = RestExecutionBuilder.get();
    }

    public static ThirdPartyAccountsClient instance() {
        if (instance == null) {
            instance = new ThirdPartyAccountsClient();
        }
        return instance;
    }

    public List<ThirdPartyAccount> getThirdPartyAccountsLocal(String authToken) {
        this.authToken = authToken;
        localThirdPartyAccounts = true;
        return (List<ThirdPartyAccount>) this.execute();
    }

    public List<ThirdPartyAccount> getThirdPartyAccountsInCountry(String authToken) {
        this.authToken = authToken;
        localThirdPartyAccounts = false;
        return (List<ThirdPartyAccount>) this.execute();
    }

    @Override
    protected Object getOffline() {
        if (localThirdPartyAccounts) {
            return Resources.jsonToObject(R.raw.accounts_local, Object.class);
        } else {
            return Resources.jsonToObject(R.raw.accounts_in_country, Object.class);
        }
    }

    @Override
    protected Object getOnline() {
        Header tokenHeader = HttpUtils.buildTokenHeader(this.authToken);

        if (localThirdPartyAccounts) {
            builder.appendUrl(PrivateUrls.GET_THIRDPARTY_ACCOUNTS_LOCAL_URL);
        } else {
            builder.appendUrl(PrivateUrls.GET_THIRDPARTY_ACCOUNTS_INCOUNTRY_URL);
        }

        return builder.appendHeader(tokenHeader).execute(ThirdPartyAccount[].class);
    }
}
