package uy.infocorp.banking.glass.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.controller.beacon.BeaconListenerService;
import uy.infocorp.banking.glass.util.resources.Resources;

public class BootCompletedReceiver extends BroadcastReceiver {

    private static final String TAG = BootCompletedReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Resources.getBoolean(R.bool.beacon_scanning)) {
            if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
                Log.i(TAG, "Boot completed, starting beacon listener service ...");

                Intent beaconListenerIntent = new Intent(context, BeaconListenerService.class);
                context.startService(beaconListenerIntent);
            }
        }
    }
}