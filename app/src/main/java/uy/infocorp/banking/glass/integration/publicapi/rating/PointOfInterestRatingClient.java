package uy.infocorp.banking.glass.integration.publicapi.rating;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.rating.dto.PointOfInterestRatingDTO;
import uy.infocorp.banking.glass.integration.publicapi.rating.dto.RatingResponseDTO;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class PointOfInterestRatingClient extends BaseClient {

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

    public boolean postPointOfInterestRating(PointOfInterestRatingDTO pointOfInterestRatingDTO) {
        this.pointOfInterestRatingDTO = pointOfInterestRatingDTO;

        RatingResponseDTO response = (RatingResponseDTO) this.execute();
        // FIXME evaluar response
        return true;
    }

    @Override
    protected Object getOffline() {
        return Resources.jsonToObject(R.raw.rating_response, RatingResponseDTO.class);
    }

    @Override
    protected Object getOnline() {
        return this.builder.appendObjectBody(this.pointOfInterestRatingDTO)
                .execute(RatingResponseDTO.class);
    }
}
