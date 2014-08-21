package uy.infocorp.banking.glass.icbankingglass.service.integration.publicapi.info.dto;

public class FrequentlyAskedQuestionsDTO {

    private String id;
    private String creationDate;
    private String order;
    private String answer;
    private String question;
    private String isDeleted;
    private String modifiedDate;
    private String[] relatedFrequentlyAskedQuestionsIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String[] getRelatedFrequentlyAskedQuestionsIds() {
        return relatedFrequentlyAskedQuestionsIds;
    }

    public void setRelatedFrequentlyAskedQuestionsIds(String[] relatedFrequentlyAskedQuestionsIds) {
        this.relatedFrequentlyAskedQuestionsIds = relatedFrequentlyAskedQuestionsIds;
    }
}
