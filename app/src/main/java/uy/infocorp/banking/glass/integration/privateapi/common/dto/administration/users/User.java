package uy.infocorp.banking.glass.integration.privateapi.common.dto.administration.users;

import java.util.Date;
import java.util.List;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.administration.sites.Site;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.authentication.AuthorizedIpAddress;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.Language;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common.ViewMode;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.security.SecurityDevice;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.Constants;

public class User {

    private int userId;
    private String userName;
    private UserType userType;
    private UserStatus userStatus;
    private Site site;
    private String name;
    private String lastName;
    private String mail;
    private int documentTypeId;
    private String documentNumber;
    private String countryId;
    private String cellPhone;
    private String workPhone;
    private Date createdDate = Constants.DATE_MIN_VALUE;
    private Date modifiedDate = Constants.DATE_MIN_VALUE;
    private Boolean canSaveDocuments = null;
    private SecurityDevice loginDevice;
    private List<SecurityDevice> transactionDevices;

    private Integer signingLevelId = null;
    private List<AuthorizedIpAddress> authorizedIpAddresses;
    private List<Integer> advertisingGroups;
    private Language language;
    private ViewMode viewMode;

    private Date lastLoginDate = Constants.DATE_MIN_VALUE;
    private Date lastPasswordChange = Constants.DATE_MIN_VALUE;

    private int loginPasswordAttempts;
    private String lastAttemptQuestions;
    private short questionAttempts;
    private String secretQuestion;

    //	private java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> extendedProperties;
    private Date resetPasswordDate = null;
    //	private UserSigningLevel userSigningLevel;
    private boolean canSignAlone;

    public final int getUserId() {
        return userId;
    }

    public final void setUserId(int value) {
        userId = value;
    }

    public final String getUserName() {
        return userName;
    }

    public final void setUserName(String value) {
        userName = value;
    }

    public final UserType getUserType() { return userType; }
    public final void setUserType(UserType value) {	userType = value; }

	public final UserStatus getUserStatus() { return userStatus; }
	public final void setUserStatus(UserStatus value) { userStatus = value; }

	public final Site getSite() { return site; }
	public final void setSite(Site value) { site = value; }

    public final String getName() {
        return name;
    }
    public final void setName(String value) {
        name = value;
    }

    public final String getLastName() {
        return lastName;
    }
    public final void setLastName(String value) {
        lastName = value;
    }

    public final String getMail() {
        return mail;
    }
    public final void setMail(String value) {
        mail = value;
    }

    public final int getDocumentTypeId() {
        return documentTypeId;
    }
    public final void setDocumentTypeId(int value) {
        documentTypeId = value;
    }

    public final String getDocumentNumber() {
        return documentNumber;
    }
    public final void setDocumentNumber(String value) {
        documentNumber = value;
    }

    public final String getCountryId() {
        return countryId;
    }
    public final void setCountryId(String value) {
        countryId = value;
    }

    public final String getCellPhone() {
        return cellPhone;
    }
    public final void setCellPhone(String value) {
        cellPhone = value;
    }

    public final String getWorkPhone() {
        return workPhone;
    }
    public final void setWorkPhone(String value) {
        workPhone = value;
    }

    public final Date getCreatedDate() {
        return createdDate;
    }
    public final void setCreatedDate(Date value) {
        createdDate = value;
    }

    public final Date getModifiedDate() {
        return modifiedDate;
    }
    public final void setModifiedDate(Date value) {
        modifiedDate = value;
    }

    public final Boolean getCanSaveDocuments() {
        return canSaveDocuments;
    }
    public final void setCanSaveDocuments(Boolean value) {
        canSaveDocuments = value;
    }

    public final SecurityDevice getLoginDevice() { return loginDevice; }
	public final void setLoginDevice(SecurityDevice value) { loginDevice = value; }

	public final List<SecurityDevice> getTransactionDevices() { return transactionDevices; }
	public final void setTransactionDevices(List<SecurityDevice> value) { transactionDevices = value; }

    public final Integer getSigningLevelId() {
        return signingLevelId;
    }

    public final void setSigningLevelId(Integer value) {
        signingLevelId = value;
    }

    public final List<AuthorizedIpAddress> getAuthorizedIpAddresses() { return authorizedIpAddresses; }
    public final void setAuthorizedIpAddresses(List<AuthorizedIpAddress> value) { authorizedIpAddresses = value; }

    @Deprecated
    public final List<Integer> getAdvertisingGroups() {
        return advertisingGroups;
    }
    @Deprecated
    public final void setAdvertisingGroups(List<Integer> value) { advertisingGroups = value; }

    public final Language getLanguage() { return language; }
    public final void setLanguage(Language value) { language = value; }

    public final ViewMode getViewMode() { return viewMode; }
    public final void setViewMode(ViewMode value) { viewMode = value; }

    public final Date getLastLoginDate() {
        return lastLoginDate;
    }
    public final void setLastLoginDate(Date value) {
        lastLoginDate = value;
    }

    public final Date getLastPasswordChange() {
        return lastPasswordChange;
    }
    public final void setLastPasswordChange(Date value) {
        lastPasswordChange = value;
    }

    public final int getLoginPasswordAttempts() {
        return loginPasswordAttempts;
    }
    public final void setLoginPasswordAttempts(int value) {
        loginPasswordAttempts = value;
    }

    public final String getLastAttemptQuestions() {
        return lastAttemptQuestions;
    }
    public final void setLastAttemptQuestions(String value) {
        lastAttemptQuestions = value;
    }

    public final short getQuestionAttempts() {
        return questionAttempts;
    }
    public final void setQuestionAttempts(short value) {
        questionAttempts = value;
    }

    public final String getSecretQuestion() {
        return secretQuestion;
    }
    public final void setSecretQuestion(String value) {
        secretQuestion = value;
    }

//	public final java.util.HashMap<String, ExtendedPropertyValue> getExtendedProperties() { return extendedProperties; }
//	public final void setExtendedProperties(java.util.HashMap<String, ExtendedPropertyValue> value) { extendedProperties = value; }

    public final Date getResetPasswordDate() {
        return resetPasswordDate;
    }
    public final void setResetPasswordDate(Date value) {
        resetPasswordDate = value;
    }

/*  public final UserSigningLevel getUserSigningLevel() { return userSigningLevel; }
	public final void setUserSigningLevel(UserSigningLevel value) { userSigningLevel = value; } */

    public final boolean getCanSignAlone() {
        return canSignAlone;
    }
    public final void setCanSignAlone(boolean value) {
        canSignAlone = value;
    }

}