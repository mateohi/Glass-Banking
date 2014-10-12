package uy.infocorp.banking.glass.controller.benefit;

import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import uy.infocorp.banking.glass.util.math.MathUtils;

public class OrientationManager {

    private static final long METERS_BETWEEN_LOCATIONS = 2;
    private static final long MILLIS_BETWEEN_LOCATIONS = TimeUnit.SECONDS.toMillis(3);
    private static final long MAX_LOCATION_AGE_MILLIS = TimeUnit.MINUTES.toMillis(30);

    /*
     * The sensors used by the compass are mounted in the movable arm on Glass. Depending on how
     * this arm is rotated, it may produce a displacement ranging anywhere from 0 to about 12
     * degrees. Since there is no way to know exactly how far the arm is rotated, we just split the
     * difference.
     */
    private static final int ARM_DISPLACEMENT_DEGREES = 6;

    private final SensorManager sensorManager;
    private final LocationManager locationManager;

    private boolean tracking;
    private float heading;
    private float pitch;
    private Location location;
    private BenefitsCompassListener listener;
    private GeomagneticField geomagneticField;
    private boolean hasInterference;

    private SensorEventListener sensorListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                hasInterference = (accuracy < SensorManager.SENSOR_STATUS_ACCURACY_LOW);
                listener.onAccuracyChanged(OrientationManager.this);
            }
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
                float[] rotationMatrix = new float[16];
                float[] orientation = new float[9];

                SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);
                SensorManager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_X,
                        SensorManager.AXIS_Z, rotationMatrix);
                SensorManager.getOrientation(rotationMatrix, orientation);

                // Pitch to see if the angle is too steep
                pitch = (float) Math.toDegrees(orientation[1]);

                // Convert the heading (which is relative to magnetic north) to one that is
                // relative to true north, using the user's current location to compute this.
                float magneticHeading = (float) Math.toDegrees(orientation[0]);
                heading = MathUtils.mod(computeTrueNorth(magneticHeading), 360.0f)
                        - ARM_DISPLACEMENT_DEGREES;

                // Notify listener on the change
                listener.onOrientationChanged(OrientationManager.this);
            }
        }
    };

    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            OrientationManager.this.location = location;
            updateGeomagneticField();
            listener.onLocationChanged(OrientationManager.this);
        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    };

    public OrientationManager(SensorManager sensorManager, LocationManager locationManager) {
        this.sensorManager = sensorManager;
        this.locationManager = locationManager;
    }

    public void start() {
        if (!tracking) {
            sensorManager.registerListener(sensorListener,
                    sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
                    SensorManager.SENSOR_DELAY_UI);

            // The rotation vector sensor doesn't give us accuracy updates, so we observe the
            // magnetic field sensor solely for those.
            sensorManager.registerListener(sensorListener,
                    sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                    SensorManager.SENSOR_DELAY_UI);

            Location lastLocation = locationManager
                    .getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            if (lastLocation != null) {
                long locationAge = lastLocation.getTime() - System.currentTimeMillis();
                if (locationAge < MAX_LOCATION_AGE_MILLIS) {
                    location = lastLocation;
                    updateGeomagneticField();
                }
            }

            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            criteria.setBearingRequired(false);
            criteria.setSpeedRequired(false);

            List<String> providers = locationManager.getProviders(criteria, true);
            for (String provider : providers) {
                locationManager.requestLocationUpdates(provider, MILLIS_BETWEEN_LOCATIONS,
                        METERS_BETWEEN_LOCATIONS, locationListener, Looper.getMainLooper());
            }

            tracking = true;
        }
    }

    public void stop() {
        if (tracking) {
            sensorManager.unregisterListener(sensorListener);
            locationManager.removeUpdates(locationListener);
            tracking = false;
        }
    }

    public boolean hasInterference() {
        return hasInterference;
    }

    public boolean hasLocation() {
        return location != null;
    }

    public float getHeading() {
        return heading;
    }

    public float getPitch() {
        return pitch;
    }

    public Location getLocation() {
        return location;
    }

    public void setBenefitsCompassListener(BenefitsCompassListener benefitsCompassListener) {
        this.listener = benefitsCompassListener;
    }

    private void updateGeomagneticField() {
        geomagneticField = new GeomagneticField((float) location.getLatitude(),
                (float) location.getLongitude(), (float) location.getAltitude(),
                location.getTime());
    }

    /*
     * Use the magnetic field to compute true (geographic) north from the specified heading
     * relative to magnetic north.
     */
    private float computeTrueNorth(float heading) {
        if (geomagneticField != null) {
            return heading + geomagneticField.getDeclination();
        }
        else {
            return heading;
        }
    }
}
