package uy.infocorp.banking.glass.integration.privateapi.thirdPartyAccounts;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.privateapi.PrivateUrls;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.ThirdPartyAccount;
import uy.infocorp.banking.glass.util.http.BaseClient;
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

    public List<ThirdPartyAccount> getThirdPartyAccountsLocal(String authToken) throws UnsupportedEncodingException {
        this.authToken = authToken;
        localThirdPartyAccounts = true;
        return (List<ThirdPartyAccount>) this.execute();
    }

    public List<ThirdPartyAccount> getThirdPartyAccountsInCountry(String authToken) throws UnsupportedEncodingException {
        this.authToken = authToken;
        localThirdPartyAccounts = false;
        return (List<ThirdPartyAccount>) this.execute();
    }

    @Override
    public Object getOffline() {
        if (localThirdPartyAccounts) {
            return Resources.jsonToObject(R.raw.accounts_local, Object.class);
        } else {
            return Resources.jsonToObject(R.raw.accounts_in_country, Object.class);
        }
    }

    @Override
    public Object getOnline() {
        String xAuthTokenHeaderName = Resources.getString(R.string.x_auth_header);
        Header tokenHeader = new BasicHeader(xAuthTokenHeaderName, this.authToken);
        ThirdPartyAccount[] servicePaymentList;
        if (localThirdPartyAccounts) {
            builder = RestExecutionBuilder.get(PrivateUrls.GET_THIRDPARTY_ACCOUNTS_LOCAL_URL);
            servicePaymentList = builder.appendHeader(tokenHeader).execute(ThirdPartyAccount[].class);
        } else {
            builder = RestExecutionBuilder.get(PrivateUrls.GET_THIRDPARTY_ACCOUNTS_INCOUNTRY_URL);
            servicePaymentList = builder.appendHeader(tokenHeader).execute(ThirdPartyAccount[].class);
        }
        return servicePaymentList;
    }
}
