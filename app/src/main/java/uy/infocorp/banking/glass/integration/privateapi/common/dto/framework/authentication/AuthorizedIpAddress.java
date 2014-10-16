package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.authentication;

import java.util.Date;

public class AuthorizedIpAddress
{
    private final Date DATE_MIN_VALUE = new Date(Long.MIN_VALUE);

    private String ipAddress;
	private String description;
	private int createdByUserId;
	private Date creationDate = DATE_MIN_VALUE;
	//private java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> extendedProperties;


	public final String getIpAddress(){ return ipAddress; }
	public final void setIpAddress(String value){ ipAddress = value; }


	public final String getDescription(){ return description; }
	public final void setDescription(String value){ description = value; }

	public final int getCreatedByUserId(){ return createdByUserId; }
	public final void setCreatedByUserId(int value){ createdByUserId = value; }

	public final Date getCreationDate(){ return creationDate; }
	public final void setCreationDate(Date value){ creationDate = value; }

	//public final java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> getExtendedProperties(){ return extendedProperties; }
	//public final void setExtendedProperties(java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> value){ extendedProperties = value; }
}