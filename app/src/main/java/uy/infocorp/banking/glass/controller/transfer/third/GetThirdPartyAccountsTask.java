package uy.infocorp.banking.glass.controller.transfer.third;

import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.accounts.ThirdPartyAccount;
import uy.infocorp.banking.glass.integration.privateapi.thirdPartyAccounts.ThirdPartyAccountsClient;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetThirdPartyAccountsTask extends SimpleAsyncTask<List<ThirdPartyAccount>> {

    private static final String TAG = GetThirdPartyAccountsTask.class.getSimpleName();

    public GetThirdPartyAccountsTask(FinishedTaskListener<List<ThirdPartyAccount>> listener) {
        super(listener);
    }

    @Override
    protected List<ThirdPartyAccount> doInBackground(Object... params) {
        try {
            String authToken = (String) params[0];
            return ThirdPartyAccountsClient.instance().getThirdPartyAccountsLocal(authToken);
        } catch (Exception e) {
            Log.e(TAG, "Unable to get third party accounts - " + e.getMessage());
            return null;
        }
    }
}
