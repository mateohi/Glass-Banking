package uy.infocorp.banking.glass.controller.benefit;

public interface BenefitsCompassListener {
    void onOrientationChanged(OrientationManager orientationManager);

    void onLocationChanged(OrientationManager orientationManager);

    void onAccuracyChanged(OrientationManager orientationManager);
}

