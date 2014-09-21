package uy.infocorp.banking.glass.controller.benefit;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.PublicApiService;
import uy.infocorp.banking.glass.integration.publicapi.benefits.BenefitsClient;
import uy.infocorp.banking.glass.model.benefit.Benefit;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetNearbyBenefitsTask extends SimpleAsyncTask<List<Benefit>> {

    private static final String TAG = GetNearbyBenefitsTask.class.getSimpleName();

    public GetNearbyBenefitsTask(FinishedTaskListener<List<Benefit>> listener) {
        super(listener);
    }

    @Override
    protected List<Benefit> doInBackground(Object... params) {
        try {
            Location location = (Location) params[0];
            return BenefitsClient.instance().getNearbyBenefits(location);
        }
        catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
    }
}
