package uy.infocorp.banking.glass.domain.beacon.estimote;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.domain.beacon.BeaconHandler;
import uy.infocorp.banking.glass.domain.beacon.PlaceListener;
import uy.infocorp.banking.glass.exception.BeaconMonitoringException;
import uy.infocorp.banking.glass.exception.BluetoothException;

public class EstimoteBeaconHandler extends BeaconHandler {

    private static final String TAG = EstimoteBeaconHandler.class.getSimpleName();

    // FIXME cambiar el proximity id por uno de IC, el major por uno del banco
    private static final Region ALL_BRANCHES_REGION = new Region("rid", null, null, null);

    private BeaconManager beaconManager;
    private final PlaceListener listener;
    private int lastMinor;

    public EstimoteBeaconHandler(Context context, final PlaceListener listener) {
        super(context);
        this.listener = listener;
        this.beaconManager = new BeaconManager(context);

        if (!this.beaconManager.hasBluetooth()) {
            throw new BluetoothException("Bluetooth not available on this device");
        }

        if (!this.beaconManager.isBluetoothEnabled()) {
            throw new BluetoothException("Bluetooth not enabled");
        }

        beaconManager.setBackgroundScanPeriod(TimeUnit.SECONDS.toMillis(1), 0);
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List<Beacon> beacons) {
                Beacon beacon = beacons.get(0);
                lastMinor = beacon.getMinor();

                Log.i(TAG, String.format("Entered region: UUID[%s], Major[%d], Minor:[%d]",
                        beacon.getProximityUUID(), beacon.getMajor(), beacon.getMinor()));
                listener.onEntered(String.valueOf(lastMinor));
            }

            @Override
            public void onExitedRegion(Region region) {
                Log.i(TAG, String.format("Exited region: UUID[%s], Major[%d], Minor:[%d]",
                        region.getProximityUUID(), region.getMajor(), region.getMinor()));
                listener.onExit(String.valueOf(lastMinor));
            }
        });
    }

    @Override
    public void startMonitoring() {
        this.beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                try {
                    beaconManager.startMonitoring(ALL_BRANCHES_REGION);
                    Log.i(TAG, "Started monitoring");
                } catch (RemoteException e) {
                    throw new BeaconMonitoringException("Unable to start monitoring beacon manager");
                }
            }
        });
    }

    @Override
    public void stopMonitoring() {
        try {
            this.beaconManager.stopMonitoring(ALL_BRANCHES_REGION);
            Log.i(TAG, "Stopped monitoring");
        } catch (RemoteException e) {
            throw new BeaconMonitoringException("Unable to stop monitoring beacon manager");
        }
    }

    @Override
    public void destroy() {
        this.beaconManager.disconnect();
    }

}
