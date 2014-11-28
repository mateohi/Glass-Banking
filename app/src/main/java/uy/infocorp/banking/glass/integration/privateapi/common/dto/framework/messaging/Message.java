package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.messaging;

import java.util.Date;
import java.util.List;

public class Message {

    private long messageId;
    private String userIdentifier;
    private boolean isImportant;
    private String templateName;
    private Date expirationDate = new Date(Long.MIN_VALUE);

    public final long getMessageId() {
        return messageId;
    }

    public final void setMessageId(long value) {
        messageId = value;
    }

    public final String getUserIdentifier() {
        return userIdentifier;
    }

    public final void setUserIdentifier(String value) {
        userIdentifier = value;
    }

    public final boolean getIsImportant() {
        return isImportant;
    }

    public final void setIsImportant(boolean value) {
        isImportant = value;
    }

    public final String getTemplateName() {
        return templateName;
    }

    public final void setTemplateName(String value) {
        templateName = value;
    }

    public final Date getExpirationDate() {
        return expirationDate;
    }

    public final void setExpirationDate(Date value) {
        expirationDate = value;
    }
//	private MessageMetadata privateTitleMetadata;
//	public final MessageMetadata getTitleMetadata() { return privateTitleMetadata; }
//	public final void setTitleMetadata(MessageMetadata value){ privateTitleMetadata = value; }

    private String privateFormattedTitle;

    public final String getFormattedTitle() {
        return privateFormattedTitle;
    }

    public final void setFormattedTitle(String value) {
        privateFormattedTitle = value;
    }

    /**
     Information about message body.
     */
//	private MessageMetadata privateBodyMetadata;
//	public final MessageMetadata getBodyMetadata() { return privateBodyMetadata; }
//	public final void setBodyMetadata(MessageMetadata value) { privateBodyMetadata = value; }

    /**
     * Message boy formatted.
     */
    private String privateFormattedBody;

    public final String getFormattedBody() {
        return privateFormattedBody;
    }

    public final void setFormattedBody(String value) {
        privateFormattedBody = value;
    }

    /**
     * Url of an image embedded in message.
     */
    private String privateImageUrl;

    public final String getImageUrl() {
        return privateImageUrl;
    }

    public final void setImageUrl(String value) {
        privateImageUrl = value;
    }

    /**
     * Url of a second image embedded in message.
     */
    private String privateImage2Url;

    public final String getImage2Url() {
        return privateImage2Url;
    }

    public final void setImage2Url(String value) {
        privateImage2Url = value;
    }

    /**
     * Urls of an others images embedded in message.
     */
    private List<String> privateImagesUrl;

    public final List<String> getImagesUrl() {
        return privateImagesUrl;
    }

    public final void setImagesUrl(List<String> value) {
        privateImagesUrl = value;
    }

    /**
     Channel to which the message is sent.
     */
//	private MessageChannelEnum privateMessageChannel;
//	public final MessageChannelEnum getMessageChannel() { return privateMessageChannel; }
//	public final void setMessageChannel(MessageChannelEnum value) { privateMessageChannel = value; }
    /**
     Status of the message.
     */
//	private MessageStatusEnum privateMessageStatus;
//	public final MessageStatusEnum getMessageStatus() { return privateMessageStatus; }
//	public final void setMessageStatus(MessageStatusEnum value) { privateMessageStatus = value; }
    /**
     * Message creation date.
     */
    private Date privateCreationDate = new Date(Long.MIN_VALUE);

    public final Date getCreationDate() {
        return privateCreationDate;
    }

    public final void setCreationDate(Date value) {
        privateCreationDate = value;
    }

    /**
     * Message sent date.
     */
    private Date privateSentDate;

    public final Date getSentDate() {
        return privateSentDate;
    }

    public final void setSentDate(Date value) {
        privateSentDate = value;
    }
    /**
     Information about message channel.
     */
//	private MessageChannelMetadata privateChannelMetadata;
//	public final MessageChannelMetadata getChannelMetadata() { return privateChannelMetadata; }
//	public final void setChannelMetadata(MessageChannelMetadata value) { privateChannelMetadata = value; }
    /**
     List of message's actions
     */
//	private List<MessageAction> privateActions;
//	public final List<MessageAction> getActions() { return privateActions; }
//	public final void setActions(List<MessageAction> value) { privateActions = value; }
    /**
     Properties to extend this object.
     */
//	private Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> privateExtendedProperties;
//	public final Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> getExtendedProperties(){ return privateExtendedProperties; }
//	public final void setExtendedProperties(Map<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> value) { privateExtendedProperties = value; }

    /**
     Specific user language
     */
//	private Language privateUserLanguage;
//	public final Language getUserLanguage() { return privateUserLanguage; }
//	public final void setUserLanguage(Language value) { privateUserLanguage = value; }

}