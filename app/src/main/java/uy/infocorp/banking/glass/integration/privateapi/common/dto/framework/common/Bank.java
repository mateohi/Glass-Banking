package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

public class Bank
{

	private int privateBankId;
	public final int getBankId(){ return privateBankId; }
	public final void setBankId(int value){ privateBankId = value; }

	private String privateDescription;
	public final String getDescription(){ return privateDescription; }
	public final void setDescription(String value){ privateDescription = value; }

	private String privateRoutingNumber;
	public final String getRoutingNumber(){ return privateRoutingNumber; }
//	public final void setRoutingNumber(String value){ RoutingNumber = value; }

/*	private Country privateCountry;
	public final Country getCountry(){ return privateCountry; }
	public final void setCountry(Country value){ privateCountry = value; }
*/
/*	private java.util.ArrayList<BankBranch> privateBankBranches;
	public final java.util.ArrayList<BankBranch> getBankBranches(){ return privateBankBranches; }
	public final void setBankBranches(java.util.ArrayList<BankBranch> value){ privateBankBranches = value; }

	private java.util.ArrayList<Subsidiary> privateSubsidairies;
	public final java.util.ArrayList<Subsidiary> getSubsidairies(){ return privateSubsidairies; }
	public final void setSubsidairies(java.util.ArrayList<Subsidiary> value){ privateSubsidairies = value; }*/

	private java.util.HashMap<String, ExtendedPropertyValue> privateExtendedProperties;
//	public final java.util.HashMap<String, ExtendedPropertyValue> getExtendedProperties(){ return privateExtendedProperties; }
//	public final void setExtendedProperties(java.util.HashMap<String, ExtendedPropertyValue> value){ privateExtendedProperties = value; }
}