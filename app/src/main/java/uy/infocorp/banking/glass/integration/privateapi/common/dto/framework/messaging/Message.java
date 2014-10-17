package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.messaging;

import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.Constants;

public class Message
{
	/** 
	 Message Identifier
	*/
	private long privateMessageId;
	public final long getMessageId() { return privateMessageId; }
	public final void setMessageId(long value) { privateMessageId = value; }
	/**
	 Owner user identifier of the message.
	*/
	private String privateUserIdentifier;
	public final String getUserIdentifier() { return privateUserIdentifier; }
	public final void setUserIdentifier(String value) { privateUserIdentifier = value; }
	/** 
	 Is important message.
	*/
	private boolean privateIsImportant;
	public final boolean getIsImportant() { return privateIsImportant; }
	public final void setIsImportant(boolean value) { privateIsImportant = value; }

	/**
	 Template message name.
	*/
	private String privateTemplateName;
    public final String getTemplateName() { return privateTemplateName; }
	public final void setTemplateName(String value) { privateTemplateName = value; }

	/**
	 Message expiration date.
	*/
	private Date privateExpirationDate = Constants.DATE_MIN_VALUE;
	public final Date getExpirationDate()
	{
		return privateExpirationDate;
	}
	public final void setExpirationDate(Date value) { privateExpirationDate = value; }
	/**
	 Information about the message title.
	*/
//	private MessageMetadata privateTitleMetadata;
//	public final MessageMetadata getTitleMetadata() { return privateTitleMetadata; }
//	public final void setTitleMetadata(MessageMetadata value){ privateTitleMetadata = value; }

	/**
	 Message title formatted.
	*/
	private String privateFormattedTitle;
	public final String getFormattedTitle() { return privateFormattedTitle; }
	public final void setFormattedTitle(String value) { privateFormattedTitle = value; }

	/**
	 Information about message body.
	*/
//	private MessageMetadata privateBodyMetadata;
//	public final MessageMetadata getBodyMetadata() { return privateBodyMetadata; }
//	public final void setBodyMetadata(MessageMetadata value) { privateBodyMetadata = value; }

	/**
	 Message boy formatted.
	*/
	private String privateFormattedBody;
	public final String getFormattedBody() { return privateFormattedBody; }
	public final void setFormattedBody(String value) { privateFormattedBody = value; }

	/**
	 Url of an image embedded in message.
	*/
	private String privateImageUrl;
	public final String getImageUrl() { return privateImageUrl; }
	public final void setImageUrl(String value) {privateImageUrl = value; }

	/**
	 Url of a second image embedded in message.
	*/
	private String privateImage2Url;
	public final String getImage2Url()
	{
		return privateImage2Url;
	}
	public final void setImage2Url(String value)
	{
		privateImage2Url = value;
	}
	/** 
	 Urls of an others images embedded in message.
	*/
	private java.util.ArrayList<String> privateImagesUrl;
	public final java.util.ArrayList<String> getImagesUrl() { return privateImagesUrl; }
	public final void setImagesUrl(java.util.ArrayList<String> value) { privateImagesUrl = value; }

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
	 Message creation date.
	*/
	private Date privateCreationDate = Constants.DATE_MIN_VALUE;
	public final Date getCreationDate()
	{
		return privateCreationDate;
	}
	public final void setCreationDate(Date value)
	{
		privateCreationDate = value;
	}

	/**
	 Message sent date.
	*/
	private Date privateSentDate = null;
	public final Date getSentDate()
	{
		return privateSentDate;
	}
	public final void setSentDate(Date value)
	{
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
//	private java.util.ArrayList<MessageAction> privateActions;
//	public final java.util.ArrayList<MessageAction> getActions() { return privateActions; }
//	public final void setActions(java.util.ArrayList<MessageAction> value) { privateActions = value; }
	/** 
	 Properties to extend this object.
	*/
//	private java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> privateExtendedProperties;
//	public final java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> getExtendedProperties(){ return privateExtendedProperties; }
//	public final void setExtendedProperties(java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> value) { privateExtendedProperties = value; }

	/** 
	 Specific user language
	*/
//	private Language privateUserLanguage;
//	public final Language getUserLanguage() { return privateUserLanguage; }
//	public final void setUserLanguage(Language value) { privateUserLanguage = value; }

}