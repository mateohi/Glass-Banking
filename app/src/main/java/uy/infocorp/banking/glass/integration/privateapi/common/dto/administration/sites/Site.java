package uy.infocorp.banking.glass.integration.privateapi.common.dto.administration.sites;

import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.Constants;
import uy.infocorp.banking.glass.integration.privateapi.common.dto.administration.users.User;

public class Site {

    private int siteId;
    private String name;
    //private SiteType siteType;
    //private SiteStatus siteStatus;
    private Date creationDate = Constants.DATE_MIN_VALUE;
    private Date approvalDate = null;
    private Integer approverUserId = null;
    private String approverUserName;
    //private ArrayList<Client> clients;
    private User siteAdministrator;
    //private HashMap<String, ExtendedPropertyValue> extendedProperties;
    //private Subsidiary mainSubsidiary;
    private boolean requiresDualApproval;

    public final int getSiteId(){ return siteId; }
    public final void setSiteId(int value) { siteId = value; }

    public final String getName() { return name; }

    public final void setName(String value) { name = value; }

    /*public final SiteType getSiteType() { return siteType; }
    public final void setSiteType(SiteType value) { siteType = value; }

    public final SiteStatus getSiteStatus() { return siteStatus; }
    public final void setSiteStatus(SiteStatus value) { siteStatus = value; }
*/
    public final Date getCreationDate() { return creationDate; }

    public final void setCreationDate(Date value) { creationDate = value; }

    public final Date getApprovalDate() { return approvalDate; }
    public final void setApprovalDate(Date value) { approvalDate = value; }

    public final Integer getApproverUserId(){ return approverUserId; }
    public final void setApproverUserId(Integer value){ approverUserId = value; }

    public final String getApproverUserName(){ return approverUserName; }
    public final void setApproverUserName(String value){ approverUserName = value; }

    /*public final ArrayList<Client> getClients(){ return clients; }
    public final void setClients(ArrayList<Client> value){ clients = value; }
*/
    public final User getSiteAdministrator(){ return siteAdministrator; }
    public final void setSiteAdministrator(User value){ siteAdministrator = value; }
/*
    public final HashMap<String, ExtendedPropertyValue> getExtendedProperties(){ return extendedProperties; }
    public final void setExtendedProperties(HashMap<String, ExtendedPropertyValue> value){ extendedProperties = value; }

    public final Subsidiary getMainSubsidiary(){ return mainSubsidiary; }
    public final void setMainSubsidiary(Subsidiary value){ mainSubsidiary = value; }
*/
    public final boolean getRequiresDualApproval(){ return requiresDualApproval; }
    public final void setRequiresDualApproval(boolean value){ requiresDualApproval = value; }
}