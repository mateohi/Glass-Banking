package uy.infocorp.banking.glass.icbankingglass.service.integration.publicapi.info.dto;

public class PublicInfoDTO {

    private FrequentlyAskedQuestionsDTO[] frequentlyAskedQuestions;
    private LinksOfInterestGroupsDTO[] linksOfInterestGroups;
    private ExchangeRatesDTO[] exchangeRates;
    private NewsFeedDTO[] newsFeed;
    private PointsOfInterestDTO[] pointsOfInterest;
    private ContactItemsGroupsDTO[] contactItemsGroups;
    private String[] benefits;
    private BannerDTO banner;

    public FrequentlyAskedQuestionsDTO[] getFrequentlyAskedQuestionsDTO() {
        return frequentlyAskedQuestions;
    }

    public void setFrequentlyAskedQuestionsDTO(FrequentlyAskedQuestionsDTO[] frequentlyAskedQuestions) {
        this.frequentlyAskedQuestions = frequentlyAskedQuestions;
    }

    public LinksOfInterestGroupsDTO[] getLinksOfInterestGroupsDTO() {
        return linksOfInterestGroups;
    }

    public void setLinksOfInterestGroupsDTO(LinksOfInterestGroupsDTO[] linksOfInterestGroups) {
        this.linksOfInterestGroups = linksOfInterestGroups;
    }

    public ExchangeRatesDTO[] getExchangeRatesDTO() {
        return exchangeRates;
    }

    public void setExchangeRatesDTO(ExchangeRatesDTO[] exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public NewsFeedDTO[] getNewsFeedDTO() {
        return newsFeed;
    }

    public void setNewsFeedDTO(NewsFeedDTO[] newsFeed) {
        this.newsFeed = newsFeed;
    }

    public PointsOfInterestDTO[] getPointsOfInterestDTO() {
        return pointsOfInterest;
    }

    public void setPointsOfInterestDTO(PointsOfInterestDTO[] pointsOfInterest) {
        this.pointsOfInterest = pointsOfInterest;
    }

    public ContactItemsGroupsDTO[] getContactItemsGroupsDTO() {
        return contactItemsGroups;
    }

    public void setContactItemsGroupsDTO(ContactItemsGroupsDTO[] contactItemsGroups) {
        this.contactItemsGroups = contactItemsGroups;
    }

    public String[] getBenefits() {
        return benefits;
    }

    public void setBenefits(String[] benefits) {
        this.benefits = benefits;
    }

    public BannerDTO getBannerDTO() {
        return banner;
    }

    public void setBannerDTO(BannerDTO banner) {
        this.banner = banner;
    }
}
