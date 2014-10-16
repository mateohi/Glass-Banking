package uy.infocorp.banking.glass.controller.beacon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import uy.infocorp.banking.glass.controller.beacon.rate.BranchRatingActivity;
import uy.infocorp.banking.glass.domain.beacon.BeaconHandler;
import uy.infocorp.banking.glass.domain.beacon.PlaceListener;
import uy.infocorp.banking.glass.domain.beacon.estimote.EstimoteBeaconHandler;

public class BeaconListenerService extends Service {

    private static final String TAG = BeaconListenerService.class.getSimpleName();
    private BeaconHandler beaconHandler;

    @Override
    public void onCreate() {
        this.beaconHandler = new EstimoteBeaconHandler(this.getApplicationContext(), new PlaceListener() {
            @Override
            public void onEntered(String placeId) {
                Log.i(TAG, "Entered " + placeId);
                // show welcome message, inform bank branch, etc..
            }

            @Override
            public void onExit(String placeId) {
                startRatingActivity(placeId);
            }
        });

        this.beaconHandler.startMonitoring();
    }

    @Override
    public void onDestroy() {
        this.beaconHandler.stopMonitoring();
        this.beaconHandler.destroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startRatingActivity(String branchId) {
        Intent ratingIntent = new Intent(this, BranchRatingActivity.class);
        ratingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ratingIntent.putExtra(BranchRatingActivity.BRANCH_ID, branchId);

        startActivity(ratingIntent);
    }
}
