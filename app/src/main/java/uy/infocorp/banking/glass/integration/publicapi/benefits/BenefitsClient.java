package uy.infocorp.banking.glass.integration.publicapi.benefits;

import android.location.Location;
import android.util.Log;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.info.PublicInfoClient;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.AssociatedPointOfInterestDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.BenefitDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PointsOfInterestDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.model.benefit.Benefit;
import uy.infocorp.banking.glass.util.math.MathUtils;

public class BenefitsClient {

    private static final String TAG = BenefitsClient.class.getSimpleName();
    private static final double MAX_DISTANCE_KM = 10;

    private static BenefitsClient instance;

    private BenefitsClient() {
    }

    public static BenefitsClient instance() {
        if (instance == null) {
            instance = new BenefitsClient();
        }
        return instance;
    }

    public List<Benefit> getNearbyBenefits(Location location) {
        PublicInfoDTO publicInfo = PublicInfoClient.instance().getPublicInfo();
        List<PointsOfInterestDTO> pointsOfInterest = Arrays.asList(publicInfo.getPointsOfInterestDTO());

        List<Benefit> nearbyBenefits = Lists.newArrayList();

        for (BenefitDTO knownBenefit : publicInfo.getBenefits()) {
            for (AssociatedPointOfInterestDTO pointOfInterest : knownBenefit.getAssociatedPointsOfInterest()) {
                PointsOfInterestDTO point = findPointById(pointsOfInterest, pointOfInterest);

                if (point != null) {
                    String name = point.getName();
                    String description = knownBenefit.getTitle();
                    double latitude = point.getLatitude();
                    double longitude = point.getLongitude();

                    float distanceToBenefit = getDistance(location, latitude, longitude);

                    if (distanceToBenefit <= MAX_DISTANCE_KM) {
                        nearbyBenefits.add(new Benefit(latitude, longitude, name, description));
                    }
                }
                else {
                    Log.w(TAG, "Unknown point of interest in benefit");
                }
            }
        }

        return nearbyBenefits;
    }

    private static PointsOfInterestDTO findPointById(List<PointsOfInterestDTO> pointsOfInterest, AssociatedPointOfInterestDTO pointOfInterest) {
        for (PointsOfInterestDTO point : pointsOfInterest) {
            if (point.getId() == pointOfInterest.getId()) {
                return point;
            }
        }

        return null;
    }

    private static float getDistance(Location location, double latitude, double longitude) {
        double userLatitude = location.getLatitude();
        double userLongitude = location.getLongitude();

        return MathUtils.getDistance(userLatitude, userLongitude, latitude, longitude);
    }
}
