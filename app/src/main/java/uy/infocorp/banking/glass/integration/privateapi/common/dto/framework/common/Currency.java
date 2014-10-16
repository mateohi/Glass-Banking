package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

public class Currency
{
	private String currencyId;
	private String currencyAlpha3Code;
	private String currencyDescription;
	private String currencySymbol;
//	private java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> extendedProperties;


	public final String getCurrencyId(){ return currencyId; }
	public final void setCurrencyId(String value){ currencyId = value; }

	public final String getCurrencyAlpha3Code(){ return currencyAlpha3Code; }
	public final void setCurrencyAlpha3Code(String value){ currencyAlpha3Code = value; }

	public final String getCurrencyDescription(){ return currencyDescription; }
	public final void setCurrencyDescription(String value){ currencyDescription = value; }

	public final String getCurrencySymbol(){ return currencySymbol; }
	public final void setCurrencySymbol(String value){ currencySymbol = value; }

//	public final java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> getExtendedProperties(){ return extendedProperties; }
//	public final void setExtendedProperties(java.util.HashMap<String, Infocorp.Framework.BusinessEntities.Common.ExtendedPropertyValue> value){ extendedProperties = value; }
}