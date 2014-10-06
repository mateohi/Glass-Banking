package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;



public class ExtendedPropertyValueDecimal extends ExtendedPropertyValue
{
	private java.math.BigDecimal extendedPropertyValue = new java.math.BigDecimal(0);

	public final java.math.BigDecimal getExtendedPropertyValue()
	{
		return extendedPropertyValue;
	}
	public final void setExtendedPropertyValue(java.math.BigDecimal value)
	{
		extendedPropertyValue = value;
	}
}