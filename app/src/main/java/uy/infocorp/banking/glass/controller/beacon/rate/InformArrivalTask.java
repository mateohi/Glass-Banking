package uy.infocorp.banking.glass.controller.beacon.rate;

import android.util.Log;

import uy.infocorp.banking.glass.domain.arrival.builder.BranchArrivalBuilder;
import uy.infocorp.banking.glass.integration.publicapi.branch.BranchArrivalClient;
import uy.infocorp.banking.glass.integration.publicapi.branch.dto.BranchArrivalRequestDTO;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class InformArrivalTask extends SimpleAsyncTask<Void> {

    private static final String TAG = InformArrivalTask.class.getSimpleName();

    public InformArrivalTask(FinishedTaskListener<Void> listener) {
        super(listener);
    }

    @Override
    protected Void doInBackground(Object... params) {
        try {
            String authToken = (String) params[0];
            String placeId = (String) params[1];

            BranchArrivalRequestDTO request = BranchArrivalBuilder.from(placeId);
            BranchArrivalClient.instance().informArrival(request, authToken);
        } catch (Exception ex) {
            Log.e(TAG, "Unable to inform arrival of user", ex);
        }

        return null;
    }
}
