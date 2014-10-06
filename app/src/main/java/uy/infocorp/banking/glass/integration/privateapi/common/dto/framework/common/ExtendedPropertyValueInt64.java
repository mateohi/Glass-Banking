package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

public class ExtendedPropertyValueInt64 extends ExtendedPropertyValue
{
	private long extendedPropertyValue;

	public final long getExtendedPropertyValue()
	{
		return extendedPropertyValue;
	}
	public final void setExtendedPropertyValue(long value)
	{
		extendedPropertyValue = value;
	}
}