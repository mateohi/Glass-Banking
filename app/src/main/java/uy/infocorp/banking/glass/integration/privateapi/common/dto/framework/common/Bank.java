package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

import java.util.Map;

public class Bank {

    private int privateBankId;

    public final int getBankId() {
        return privateBankId;
    }

    public final void setBankId(int value) {
        privateBankId = value;
    }

    private String privateDescription;

    public final String getDescription() {
        return privateDescription;
    }

    public final void setDescription(String value) {
        privateDescription = value;
    }

    private String privateRoutingNumber;

    public final String getRoutingNumber() {
        return privateRoutingNumber;
    }
//	public final void setRoutingNumber(String value){ RoutingNumber = value; }

/*	private Country privateCountry;
    public final Country getCountry(){ return privateCountry; }
	public final void setCountry(Country value){ privateCountry = value; }
*/
/*	private List<BankBranch> privateBankBranches;
    public final List<BankBranch> getBankBranches(){ return privateBankBranches; }
	public final void setBankBranches(List<BankBranch> value){ privateBankBranches = value; }

	private List<Subsidiary> privateSubsidairies;
	public final List<Subsidiary> getSubsidairies(){ return privateSubsidairies; }
	public final void setSubsidairies(List<Subsidiary> value){ privateSubsidairies = value; }*/

    private Map<String, Object> extendedProperties;

    public Map<String, Object> getExtendedProperties() {
        return extendedProperties;
    }

    public void setExtendedProperties(Map<String, Object> extendedProperties) {
        this.extendedProperties = extendedProperties;
    }
}