package uy.infocorp.banking.glass.integration.publicapi.info.dto;

public class AdvertisingImagesDTO {

    private String imageId;
    private String order;
    private String placeHolderConfigId;
    private String advertisingImageId;
    private ActionsDTO[] actions;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPlaceHolderConfigId() {
        return placeHolderConfigId;
    }

    public void setPlaceHolderConfigId(String placeHolderConfigId) {
        this.placeHolderConfigId = placeHolderConfigId;
    }

    public String getAdvertisingImageId() {
        return advertisingImageId;
    }

    public void setAdvertisingImageId(String advertisingImageId) {
        this.advertisingImageId = advertisingImageId;
    }

    public ActionsDTO[] getActionsDTO() {
        return actions;
    }

    public void setActionsDTO(ActionsDTO[] actions) {
        this.actions = actions;
    }
}

