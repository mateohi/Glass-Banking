package uy.infocorp.banking.glass.controller.branch;

import android.location.Location;
import android.util.Log;

import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.branch.BranchClient;
import uy.infocorp.banking.glass.model.benefit.Branch;
import uy.infocorp.banking.glass.util.async.FinishedTaskListener;
import uy.infocorp.banking.glass.util.async.SimpleAsyncTask;

public class GetClosestBranchesTask extends SimpleAsyncTask<List<Branch>> {

    private static final String TAG = GetClosestBranchesTask.class.getSimpleName();

    public GetClosestBranchesTask(FinishedTaskListener<List<Branch>> listener) {
        super(listener);
    }

    @Override
    protected List<Branch> doInBackground(Object... params) {
        try {
            Location location = (Location) params[0];
            return BranchClient.instance().getClosestBranches(location);
        } catch (RuntimeException e) {
            Log.e(TAG, "Unable to get closest branches - " + e.getMessage());
            return null;
        }
    }
}
