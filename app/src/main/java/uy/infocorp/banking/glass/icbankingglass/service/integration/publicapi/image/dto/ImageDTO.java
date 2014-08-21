package uy.infocorp.banking.glass.icbankingglass.service.integration.publicapi.image.dto;

public class ImageDTO {

    private String creationDate;
    private String imagePicture;
    private int height;
    private int imageId;
    private String imageType;
    private int width;
    private String modifiedDate;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getImagePicture() {
        return imagePicture;
    }

    public void setImagePicture(String imagePicture) {
        this.imagePicture = imagePicture;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}


