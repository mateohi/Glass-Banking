package uy.infocorp.banking.glass.domain.rating.builder;

import uy.infocorp.banking.glass.integration.publicapi.info.dto.PointsOfInterestDTO;
import uy.infocorp.banking.glass.integration.publicapi.rating.dto.PointOfInterestRatingDTO;

public class PointOfInterestRatingBuilder {

    public static PointOfInterestRatingDTO from(int pointOfInterestId, boolean positive) {
        int rating = positive ? 5 : 1;

        PointsOfInterestDTO pointOfInterest = new PointsOfInterestDTO();
        pointOfInterest.setId(pointOfInterestId);

        PointOfInterestRatingDTO pointOfInterestRatingDTO = new PointOfInterestRatingDTO();
        pointOfInterestRatingDTO.setRating(rating);
        pointOfInterestRatingDTO.setPointOfInterest(pointOfInterest);

        return pointOfInterestRatingDTO;
    }
}
