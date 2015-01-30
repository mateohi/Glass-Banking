package uy.infocorp.banking.glass.integration.publicapi.rating.dto;

import uy.infocorp.banking.glass.integration.publicapi.info.dto.PointsOfInterestDTO;

public class PointOfInterestRatingDTO {

    private PointsOfInterestDTO pointOfInterest;
    private int rating;
    private String review;

    public PointsOfInterestDTO getPointOfInterest() {
        return pointOfInterest;
    }

    public void setPointOfInterest(PointsOfInterestDTO pointOfInterest) {
        this.pointOfInterest = pointOfInterest;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
