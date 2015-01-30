package uy.infocorp.banking.glass.controller.beacon.rate;

import android.util.Log;

import uy.infocorp.banking.glass.domain.rating.builder.PointOfInterestRatingBuilder;
import uy.infocorp.banking.glass.integration.publicapi.rating.PointOfInterestRatingClient;
import uy.infocorp.banking.glass.integration.publicapi.rating.dto.PointOfInterestRatingDTO;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class RateBranchTask extends SimpleAsyncTask<Boolean> {

    private static final String TAG = RateBranchTask.class.getSimpleName();

    public RateBranchTask(FinishedTaskListener<Boolean> listener) {
        super(listener);
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        try {
            int branchId = (Integer) params[0];
            Boolean positive = (Boolean) params[1];

            PointOfInterestRatingDTO rating = PointOfInterestRatingBuilder.from(branchId, positive);

            return PointOfInterestRatingClient.instance().postPointOfInterestRating(rating);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }
}
