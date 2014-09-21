package uy.infocorp.banking.glass.integration.publicapi;

import android.graphics.Bitmap;
import android.location.Location;
import android.util.Log;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.exchange.ExchangeRateClient;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.integration.publicapi.image.ImageDownloadClient;
import uy.infocorp.banking.glass.integration.publicapi.image.dto.ImageDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.PublicInfoClient;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.AssociatedPointOfInterestDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.BenefitDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PointsOfInterestDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.model.benefit.Atm;
import uy.infocorp.banking.glass.model.benefit.Benefit;
import uy.infocorp.banking.glass.model.benefit.Branch;
import uy.infocorp.banking.glass.util.graphics.BitmapUtils;
import uy.infocorp.banking.glass.util.math.MathUtils;

public class PublicApiService {

    private static final String TAG = PublicApiService.class.getSimpleName();
    private static final String INTEREST_POINT_ATM = "atm";
    private static final String INTEREST_POINT_BRANCH = "branch";
    private static final double MAX_DISTANCE_KM = 10;

    public static List<Atm> getClosestAtms(Location location) {
        PublicInfoDTO publicInfo = PublicInfoClient.instance().getPublicInfo();

        List<PointsOfInterestDTO> atms = new ArrayList<PointsOfInterestDTO>();

        for (PointsOfInterestDTO pointOfInterest : publicInfo.getPointsOfInterestDTO()) {
            String type = pointOfInterest.getType();
            float distanceToAtm = getDistance(location, pointOfInterest.getLatitude(),
                    pointOfInterest.getLongitude());

            if (INTEREST_POINT_ATM.equals(type) && MAX_DISTANCE_KM <= distanceToAtm) {
                atms.add(pointOfInterest);
            }
        }

        getThreeClosestPointsOfInterest(location, atms);

        return pointsOfInterestToAtms(atms, location);
    }

    public static List<Branch> getClosestBranches(final Location location) {
        PublicInfoDTO publicInfo = PublicInfoClient.instance().getPublicInfo();

        List<PointsOfInterestDTO> branches = new ArrayList<PointsOfInterestDTO>();

        for (PointsOfInterestDTO pointOfInterest : publicInfo.getPointsOfInterestDTO()) {
            String type = pointOfInterest.getType();
            float distanceToAtm = getDistance(location, pointOfInterest.getLatitude(),
                    pointOfInterest.getLongitude());

            if (INTEREST_POINT_BRANCH.equals(type) && MAX_DISTANCE_KM <= distanceToAtm) {
                branches.add(pointOfInterest);
            }
        }

        getThreeClosestPointsOfInterest(location, branches);

        return pointsOfInterestToBranches(branches, location);
    }

    private static List<PointsOfInterestDTO> getThreeClosestPointsOfInterest(final Location location, List<PointsOfInterestDTO> branches) {
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

    public static List<Benefit> getNearbyBenefits(Location location) {
        PublicInfoDTO publicInfo = PublicInfoClient.instance().getPublicInfo();
        List<PointsOfInterestDTO> pointsOfInterest = Arrays.asList(publicInfo.getPointsOfInterestDTO());

        List<Benefit> nearbyBenefits = new ArrayList<Benefit>();

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

    public static List<ExchangeRateDTO> getExchangeRatesByAlpha3Code(String alpha3Code) {
        ExchangeRateDTO[] exchangeRates = ExchangeRateClient.instance().getExchangeRates();

        if (ArrayUtils.isEmpty(exchangeRates)) {
            return Collections.emptyList();
        }

        List<ExchangeRateDTO> filteredRates = new ArrayList<ExchangeRateDTO>();
        for (ExchangeRateDTO exchangeRate : exchangeRates) {
            String sourceAlpha3Code = exchangeRate.getSourceCurrencyDTO().getCurrencyAlpha3Code();
            String destinationAlpha3Code = exchangeRate.getDestinationCurrencyDTO().getCurrencyAlpha3Code();

            if (sourceAlpha3Code.equals(alpha3Code) && !sourceAlpha3Code.equals(destinationAlpha3Code)) {
                filteredRates.add(exchangeRate);
            }
        }

        return filteredRates;
    }

    public static Bitmap getImage(int imageId) {
        ImageDTO imageDTO = ImageDownloadClient.instance().getImage(imageId);
        String imageBase64 = imageDTO.getImagePicture();

        return BitmapUtils.base64ToBitmap(imageBase64);
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

    private static List<Atm> pointsOfInterestToAtms(List<PointsOfInterestDTO> atmsDTO, Location location) {
        List<Atm> atms = new ArrayList<Atm>();

        for (PointsOfInterestDTO atmDTO : atmsDTO) {
            try {
                String name = atmDTO.getName();
                double latitude = atmDTO.getLatitude();
                double longitude = atmDTO.getLongitude();
                double distance = getDistance(location, latitude, longitude);
                Bitmap image = getImage(atmDTO.getImageId());

                Atm atm = new Atm();
                atm.setName(name);
                atm.setLatitude(latitude);
                atm.setLongitude(longitude);
                atm.setDistance(distance);
                atm.setImage(image);

                atms.add(atm);

                if (atms.size() == 3) {
                    break;
                }
            }
            catch (Exception e) {
                Log.e(TAG, "No image found for id: " + atmDTO.getImageId());
            }
        }
        return atms;
    }

    private static List<Branch> pointsOfInterestToBranches(List<PointsOfInterestDTO> branchesDTO, Location location) {
        List<Branch> branches = new ArrayList<Branch>();

        for (PointsOfInterestDTO branchDTO : branchesDTO) {
            try {
                String name = branchDTO.getName();
                double latitude = branchDTO.getLatitude();
                double longitude = branchDTO.getLongitude();
                double distance = getDistance(location, latitude, longitude);
                String telephone = branchDTO.getTelephone();
                Bitmap image = getImage(branchDTO.getImageId());

                Branch branch = new Branch();
                branch.setName(name);
                branch.setLatitude(latitude);
                branch.setLongitude(longitude);
                branch.setDistance(distance);
                branch.setImage(image);
                branch.setTelephone(telephone);

                branches.add(branch);

                if (branches.size() == 3) {
                    break;
                }
            }
            catch (Exception e) {
                Log.e(TAG, "No image found for id: " + branchDTO.getImageId());
                // We do not add the branch and go on
            }
        }
        return branches;
    }
}
