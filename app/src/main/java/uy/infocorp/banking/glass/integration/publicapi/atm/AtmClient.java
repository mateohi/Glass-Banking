package uy.infocorp.banking.glass.integration.publicapi.atm;

import android.graphics.Bitmap;
import android.location.Location;
import android.util.Log;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.image.ImageDownloadClient;
import uy.infocorp.banking.glass.integration.publicapi.info.PublicInfoClient;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PointsOfInterestDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.model.benefit.Atm;
import uy.infocorp.banking.glass.util.math.MathUtils;
import uy.infocorp.banking.glass.util.resources.Resources;

public class AtmClient {

    private static final String TAG = AtmClient.class.getSimpleName();

    private static final String INTEREST_POINT_ATM = Resources.getString(R.string.interest_point_atm);
    private static final double MAX_DISTANCE_KM = Resources.getInteger(R.integer.max_distance_atm);
    private static final int MAX_ATMS_TO_SHOW = Resources.getInteger(R.integer.max_atms_to_show);

    private static AtmClient instance;

    private AtmClient() {
    }

    public static AtmClient instance() {
        if (instance == null) {
            instance = new AtmClient();
        }
        return instance;
    }

    public List<Atm> getClosestAtms(Location location) {
        PublicInfoDTO publicInfo = PublicInfoClient.instance().getPublicInfo();

        List<PointsOfInterestDTO> atms = Lists.newArrayList();

        for (PointsOfInterestDTO pointOfInterest : publicInfo.getPointsOfInterestDTO()) {
            String type = pointOfInterest.getType();
            float distanceToAtm = getDistance(location, pointOfInterest.getLatitude(),
                    pointOfInterest.getLongitude());

            if (INTEREST_POINT_ATM.equals(type) && distanceToAtm < MAX_DISTANCE_KM) {
                atms.add(pointOfInterest);
            }
        }

        sortByDistance(location, atms);

        return pointsOfInterestToAtms(atms, location);
    }

    private static List<PointsOfInterestDTO> sortByDistance(final Location location,
                                                            List<PointsOfInterestDTO> branches) {
        Collections.sort(branches, new Comparator<PointsOfInterestDTO>() {
            @Override
            public int compare(PointsOfInterestDTO left, PointsOfInterestDTO right) {
                Float lDistance = getDistance(location, left.getLatitude(), left.getLongitude());
                Float rDistance = getDistance(location, right.getLatitude(), right.getLongitude());

                return lDistance.compareTo(rDistance);
            }
        });

        return branches;
    }

    private static List<Atm> pointsOfInterestToAtms(List<PointsOfInterestDTO> atmsDTO,
                                                    Location location) {
        List<Atm> atms = Lists.newArrayList();

        for (PointsOfInterestDTO atmDTO : atmsDTO) {
            try {
                String name = atmDTO.getName();
                double latitude = atmDTO.getLatitude();
                double longitude = atmDTO.getLongitude();
                double distance = getDistance(location, latitude, longitude);
                Bitmap image = ImageDownloadClient.instance().getImage(atmDTO.getImageId());

                Atm atm = new Atm();
                atm.setName(name);
                atm.setLatitude(latitude);
                atm.setLongitude(longitude);
                atm.setDistance(distance);
                atm.setImage(image);

                atms.add(atm);

                if (atms.size() == MAX_ATMS_TO_SHOW) {
                    break;
                }
            } catch (Exception e) {
                Log.e(TAG, "No image found for id: " + atmDTO.getImageId());
            }
        }
        return atms;
    }

    private static float getDistance(Location location, double latitude, double longitude) {
        double userLatitude = location.getLatitude();
        double userLongitude = location.getLongitude();

        return MathUtils.getDistance(userLatitude, userLongitude, latitude, longitude);
    }
}
