package uy.infocorp.banking.glass.integration.publicapi.info;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.ResourceUtils;

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
        if (ResourceUtils.offline()) {
            return ResourceUtils.jsonToObject(R.raw.public_info, PublicInfoDTO.class);
        }

        return this.builder.execute(PublicInfoDTO.class);
    }

}
