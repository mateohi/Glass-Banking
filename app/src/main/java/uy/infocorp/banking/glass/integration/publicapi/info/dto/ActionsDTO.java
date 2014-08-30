package uy.infocorp.banking.glass.integration.publicapi.info.dto;

public class ActionsDTO {

    private String advertisingImageActionId;
    private String advertisingImageId;
    private MetadataDTO metadata;

    public String getAdvertisingImageActionId() {
        return advertisingImageActionId;
    }

    public void setAdvertisingImageActionId(String advertisingImageActionId) {
        this.advertisingImageActionId = advertisingImageActionId;
    }

    public String getAdvertisingImageId() {
        return advertisingImageId;
    }

    public void setAdvertisingImageId(String advertisingImageId) {
        this.advertisingImageId = advertisingImageId;
    }

    public MetadataDTO getMetadataDTO() {
        return metadata;
    }

    public void setMetadataDTO(MetadataDTO metadata) {
        this.metadata = metadata;
    }
}


