package uy.infocorp.banking.glass.integration.publicapi.info;

import uy.infocorp.banking.glass.integration.Constants;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;

public class PublicInfoClient {

    private static PublicInfoClient instance;
    private RestExecutionBuilder builder;

    private PublicInfoClient() {
        this.builder = RestExecutionBuilder.get(PublicUrls.GET_PUBLIC_INFO_URL);
    }

    public static PublicInfoClient instance() {
        if (instance == null) {
            instance = new PublicInfoClient();
        }
        return instance;
    }

    public PublicInfoDTO getPublicInfo() {
        if (Constants.OFFLINE_MODE) {
            return OfflinePublicInfoClient.getPublicInfo();
        }

        return this.builder.execute(PublicInfoDTO.class);
    }

}
