package uy.infocorp.banking.glass.integration.publicapi.info;

import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.util.http.HttpUtils;

public class OfflinePublicInfoClient {

    private static final String OFFLINE_JSON = "";

    public static PublicInfoDTO getPublicInfo() {
        return HttpUtils.typeFromStringData(OFFLINE_JSON, PublicInfoDTO.class);
    }
}
