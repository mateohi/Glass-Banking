package uy.infocorp.banking.glass.integration.publicapi;

import android.graphics.Bitmap;
import android.location.Location;
import android.util.Log;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import uy.infocorp.banking.glass.model.benefit.Benefit;
import uy.infocorp.banking.glass.util.graphics.BitmapUtils;
import uy.infocorp.banking.glass.util.math.MathUtils;

public class PublicApiService {

    private static final String TAG = PublicApiService.class.getSimpleName();
    private static final String INTEREST_POINT_ATM = "atm";
    private static final String INTEREST_POINT_BRANCH = "branch";
    private static final double MAX_DISTANCE_KM = 10;

    public static List<PointsOfInterestDTO> getNearbyAtms(Location location) {
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

        return atms;
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
}
