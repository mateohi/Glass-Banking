package uy.infocorp.banking.glass.integration.publicapi.rating;

import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.rating.dto.PointOfInterestRatingDTO;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.http.VoidBaseClient;

public class PointOfInterestRatingClient extends VoidBaseClient {

    private static PointOfInterestRatingClient instance;
    private RestExecutionBuilder builder;

    private PointOfInterestRatingDTO pointOfInterestRatingDTO;

    private PointOfInterestRatingClient() {
        this.builder = RestExecutionBuilder.post(PublicUrls.POST_POINT_OF_INTEREST_RATING);
    }

    public static PointOfInterestRatingClient instance() {
        if (instance == null) {
            instance = new PointOfInterestRatingClient();
        }
        return instance;
    }

    public void postPointOfInterestRating(PointOfInterestRatingDTO pointOfInterestRatingDTO) {
        this.pointOfInterestRatingDTO = pointOfInterestRatingDTO;

        this.execute();
    }

    @Override
    protected void getOnlineVoid() {
        this.builder.appendObjectBody(this.pointOfInterestRatingDTO).execute();
    }
}
