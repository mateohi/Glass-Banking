package uy.infocorp.banking.glass.domain.beacon;

import android.content.Context;

public abstract class BeaconHandler {

    protected Context context;

    protected BeaconHandler(Context context) {
        this.context = context;
    }

    public abstract void startMonitoring();
    public abstract void stopMonitoring();
    public abstract void destroy();
}
