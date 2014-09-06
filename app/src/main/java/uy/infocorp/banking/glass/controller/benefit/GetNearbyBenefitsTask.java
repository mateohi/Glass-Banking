package uy.infocorp.banking.glass.controller.benefit;

import android.location.Location;

import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.PublicApiService;
import uy.infocorp.banking.glass.model.benefit.Benefit;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetNearbyBenefitsTask extends SimpleAsyncTask<List<Benefit>> {

    public GetNearbyBenefitsTask(FinishedTaskListener<List<Benefit>> listener) {
        super(listener);
    }

    @Override
    protected List<Benefit> doInBackground(Object... params) {
        Location location = (Location) params[0];
        return PublicApiService.getNearbyBenefits(location);
    }
}
