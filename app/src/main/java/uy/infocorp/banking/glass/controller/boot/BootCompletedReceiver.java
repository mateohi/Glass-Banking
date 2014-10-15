package uy.infocorp.banking.glass.controller.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import uy.infocorp.banking.glass.controller.beacon.BeaconListenerService;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent beaconListenerIntent = new Intent(context, BeaconListenerService.class);
            context.startService(beaconListenerIntent);
        }
    }
}