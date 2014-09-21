package uy.infocorp.banking.glass.controller.atm;

import android.location.Location;
import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.atm.AtmClient;
import uy.infocorp.banking.glass.model.benefit.Atm;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetClosestAtmsTask extends SimpleAsyncTask<List<Atm>> {

    private static final String TAG = GetClosestAtmsTask.class.getSimpleName();

    public GetClosestAtmsTask(FinishedTaskListener<List<Atm>> listener) {
        super(listener);
    }

    @Override
    protected List<Atm> doInBackground(Object... params) {
        try {
            Location location = (Location) params[0];
            return AtmClient.instance().getClosestAtms(location);
        }
        catch (Exception e) {
            Log.e(TAG, "Unable to get closest atms -" + e.getMessage());
            return null;
        }
    }
}
