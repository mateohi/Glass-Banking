package uy.infocorp.banking.glass.integration.publicapi.info.dto;

public class BannerDTO {

    private String creationDate;
    private String placeHolderId;
    private String placeHolderConfigId;
    private AdvertisingImagesDTO[] advertisingImages;
    private String rotationTime;
    private String isAutoRotate;
    private String modifiedDate;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPlaceHolderId() {
        return placeHolderId;
    }

    public void setPlaceHolderId(String placeHolderId) {
        this.placeHolderId = placeHolderId;
    }

    public String getPlaceHolderConfigId() {
        return placeHolderConfigId;
    }

    public void setPlaceHolderConfigId(String placeHolderConfigId) {
        this.placeHolderConfigId = placeHolderConfigId;
    }

    public AdvertisingImagesDTO[] getAdvertisingImagesDTO() {
        return advertisingImages;
    }

    public void setAdvertisingImagesDTO(AdvertisingImagesDTO[] advertisingImages) {
        this.advertisingImages = advertisingImages;
    }

    public String getRotationTime() {
        return rotationTime;
    }

    public void setRotationTime(String rotationTime) {
        this.rotationTime = rotationTime;
    }

    public String getIsAutoRotate() {
        return isAutoRotate;
    }

    public void setIsAutoRotate(String isAutoRotate) {
        this.isAutoRotate = isAutoRotate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

