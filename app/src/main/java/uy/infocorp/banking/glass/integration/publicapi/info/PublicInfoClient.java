package uy.infocorp.banking.glass.integration.publicapi.info;

import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.util.http.RestClientBuilder;

public class PublicInfoClient {

    private static PublicInfoClient instance;
    private RestClientBuilder client;

    private PublicInfoClient() {
        this.client = new RestClientBuilder();
    }

    public static PublicInfoClient instance() {
        if (instance == null) {
            instance = new PublicInfoClient();
        }
        return instance;
    }

    public PublicInfoDTO getPublicInfo() {
        return this.client.get(PublicUrls.GET_PUBLIC_INFO_URL).execute(PublicInfoDTO.class);
    }

}
