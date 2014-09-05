package uy.infocorp.banking.glass.integration.publicapi.info.dto;

public class BenefitDTO {

    private String body;
    private String textColor;
    private String expirationDate;
    private String backgroundColor;
    private String listFormat;
    private String type;
    private boolean isDeleted;
    private String modifiedDate;
    private int detailImageId;
    private String detailFormat;
    private int id;
    private String creationDate;
    private String title;
    private String moreInformationUrl;
    private String publishedDate;
    private int listImageId;
    private AssociatedPointOfInterestDTO[] associatedPointsOfInterest;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getListFormat() {
        return listFormat;
    }

    public void setListFormat(String listFormat) {
        this.listFormat = listFormat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getDetailImageId() {
        return detailImageId;
    }

    public void setDetailImageId(int detailImageId) {
        this.detailImageId = detailImageId;
    }

    public String getDetailFormat() {
        return detailFormat;
    }

    public void setDetailFormat(String detailFormat) {
        this.detailFormat = detailFormat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoreInformationUrl() {
        return moreInformationUrl;
    }

    public void setMoreInformationUrl(String moreInformationUrl) {
        this.moreInformationUrl = moreInformationUrl;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getListImageId() {
        return listImageId;
    }

    public void setListImageId(int listImageId) {
        this.listImageId = listImageId;
    }

    public AssociatedPointOfInterestDTO[] getAssociatedPointsOfInterest() {
        return associatedPointsOfInterest;
    }

    public void setAssociatedPointsOfInterest(AssociatedPointOfInterestDTO[] associatedPointsOfInterest) {
        this.associatedPointsOfInterest = associatedPointsOfInterest;
    }
}