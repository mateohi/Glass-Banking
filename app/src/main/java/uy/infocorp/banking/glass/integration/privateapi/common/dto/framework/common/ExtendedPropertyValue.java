package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;


public class ExtendedPropertyValue extends ExtendedPropertyValueBase {

    private boolean _isTypeAndValueInitialized;
    private ExtendedPropertyValueTypeAndValue _typeAndValue;

    @Override
    protected ExtendedPropertyValueTypeAndValue getTypeAndValue() {
        if (!_isTypeAndValueInitialized) {
            ExtendedPropertyValueString extendedPropertyValueString = (ExtendedPropertyValueString) ((this instanceof ExtendedPropertyValueString) ? this : null);
            if (extendedPropertyValueString != null) {
                ExtendedPropertyValueTypeAndValue tempVar = new ExtendedPropertyValueTypeAndValue();
                //tempVar.Type = ExtendedPropertyValueType.String;
                //tempVar.Value = extendedPropertyValueString.ExtendedPropertyValue;
                _typeAndValue = tempVar;
            } else {
                ExtendedPropertyValueInt32 extendedPropertyValueInt32 = (ExtendedPropertyValueInt32) ((this instanceof ExtendedPropertyValueInt32) ? this : null);
                if (extendedPropertyValueInt32 != null) {
                    ExtendedPropertyValueTypeAndValue tempVar2 = new ExtendedPropertyValueTypeAndValue();
                    //tempVar2.Type = ExtendedPropertyValueType.Int32;
                    //tempVar2.Value = extendedPropertyValueInt32.ExtendedPropertyValue;
                    _typeAndValue = tempVar2;
                } else {
                    ExtendedPropertyValueDecimal extendedPropertyValueDecimal = (ExtendedPropertyValueDecimal) ((this instanceof ExtendedPropertyValueDecimal) ? this : null);
                    if (extendedPropertyValueDecimal != null) {
                        ExtendedPropertyValueTypeAndValue tempVar3 = new ExtendedPropertyValueTypeAndValue();
                        //tempVar3.Type = ExtendedPropertyValueType.Decimal;
                        //tempVar3.Value = extendedPropertyValueDecimal.ExtendedPropertyValue;
                        _typeAndValue = tempVar3;
                    } else {
                        ExtendedPropertyValueDateTime extendedPropertyValueDateTime = (ExtendedPropertyValueDateTime) ((this instanceof ExtendedPropertyValueDateTime) ? this : null);
                        if (extendedPropertyValueDateTime != null) {
                            ExtendedPropertyValueTypeAndValue tempVar4 = new ExtendedPropertyValueTypeAndValue();
                            //tempVar4.Type = ExtendedPropertyValueType.DateTime;
                            //tempVar4.Value = extendedPropertyValueDateTime.ExtendedPropertyValue;
                            _typeAndValue = tempVar4;
                        } else {
                            ExtendedPropertyValueExtensibleEnum extendedPropertyValueExtensibleEnum = (ExtendedPropertyValueExtensibleEnum) ((this instanceof ExtendedPropertyValueExtensibleEnum) ? this : null);
                            if (extendedPropertyValueExtensibleEnum != null) {
                                ExtendedPropertyValueTypeAndValue tempVar5 = new ExtendedPropertyValueTypeAndValue();
                                //tempVar5.Type = ExtendedPropertyValueType.ExtensibleEnum;
                                //tempVar5.Value = extendedPropertyValueExtensibleEnum.ExtendedPropertyValue;
                                _typeAndValue = tempVar5;
                            } else {
                                ExtendedPropertyValueInt64 extendedPropertyValueInt64 = (ExtendedPropertyValueInt64) ((this instanceof ExtendedPropertyValueInt64) ? this : null);
                                if (extendedPropertyValueInt64 != null) {
                                    ExtendedPropertyValueTypeAndValue tempVar6 = new ExtendedPropertyValueTypeAndValue();
                                    //tempVar6.Type = ExtendedPropertyValueType.Int64;
                                    //tempVar6.Value = extendedPropertyValueInt64.ExtendedPropertyValue;
                                    _typeAndValue = tempVar6;
                                } else {
                                    ExtendedPropertyValueBoolean extendedPropertyValueBoolean = (ExtendedPropertyValueBoolean) ((this instanceof ExtendedPropertyValueBoolean) ? this : null);
                                    if (extendedPropertyValueBoolean != null) {
                                        ExtendedPropertyValueTypeAndValue tempVar7 = new ExtendedPropertyValueTypeAndValue();
                                        //tempVar7.Type = ExtendedPropertyValueType.Boolean;
                                        //tempVar7.Value = extendedPropertyValueBoolean.ExtendedPropertyValue;
                                        _typeAndValue = tempVar7;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            _isTypeAndValueInitialized = true;
        }

        return _typeAndValue;
    }
/*
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Operators

//C# TO JAVA CONVERTER TODO TASK: The following operator overload is not converted by C# to Java Converter:
	public static implicit operator ExtendedPropertyValue(String extendedPropertyValue)
	{
		ExtendedPropertyValueString tempVar = new ExtendedPropertyValueString();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

//C# TO JAVA CONVERTER TODO TASK: The following operator overload is not converted by C# to Java Converter:
	public static implicit operator ExtendedPropertyValue(int extendedPropertyValue)
	{
		ExtendedPropertyValueInt32 tempVar = new ExtendedPropertyValueInt32();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

//C# TO JAVA CONVERTER TODO TASK: The following operator overload is not converted by C# to Java Converter:
	public static implicit operator ExtendedPropertyValue(long extendedPropertyValue)
	{
		ExtendedPropertyValueInt64 tempVar = new ExtendedPropertyValueInt64();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

//C# TO JAVA CONVERTER TODO TASK: The following operator overload is not converted by C# to Java Converter:
	public static implicit operator ExtendedPropertyValue(java.math.BigDecimal extendedPropertyValue)
	{
		ExtendedPropertyValueDecimal tempVar = new ExtendedPropertyValueDecimal();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

//C# TO JAVA CONVERTER TODO TASK: The following operator overload is not converted by C# to Java Converter:
	public static implicit operator ExtendedPropertyValue(java.time.LocalDateTime extendedPropertyValue)
	{
		ExtendedPropertyValueDateTime tempVar = new ExtendedPropertyValueDateTime();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

//C# TO JAVA CONVERTER TODO TASK: The following operator overload is not converted by C# to Java Converter:
	public static implicit operator ExtendedPropertyValue(boolean extendedPropertyValue)
	{
		ExtendedPropertyValueBoolean tempVar = new ExtendedPropertyValueBoolean();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

//C# TO JAVA CONVERTER TODO TASK: The following operator overload is not converted by C# to Java Converter:
	public static implicit operator ExtendedPropertyValue(ExtensibleEnum extendedPropertyValue)
	{
		ExtendedPropertyValueExtensibleEnum tempVar = new ExtendedPropertyValueExtensibleEnum();
		tempVar.ExtendedPropertyValue = (int)extendedPropertyValue;
		return tempVar;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Create methods

	public static ExtendedPropertyValueString Create(String extendedPropertyValue)
	{
		ExtendedPropertyValueString tempVar = new ExtendedPropertyValueString();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

	public static ExtendedPropertyValueInt32 Create(int extendedPropertyValue)
	{
		ExtendedPropertyValueInt32 tempVar = new ExtendedPropertyValueInt32();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

	public static ExtendedPropertyValueInt64 Create(long extendedPropertyValue)
	{
		ExtendedPropertyValueInt64 tempVar = new ExtendedPropertyValueInt64();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

	public static ExtendedPropertyValueDecimal Create(java.math.BigDecimal extendedPropertyValue)
	{
		ExtendedPropertyValueDecimal tempVar = new ExtendedPropertyValueDecimal();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

	public static ExtendedPropertyValueDateTime Create(java.time.LocalDateTime extendedPropertyValue)
	{
		ExtendedPropertyValueDateTime tempVar = new ExtendedPropertyValueDateTime();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

	public static ExtendedPropertyValueBoolean Create(boolean extendedPropertyValue)
	{
		ExtendedPropertyValueBoolean tempVar = new ExtendedPropertyValueBoolean();
		tempVar.ExtendedPropertyValue = extendedPropertyValue;
		return tempVar;
	}

	public static ExtendedPropertyValueExtensibleEnum Create(ExtensibleEnum extendedPropertyValue)
	{
		ExtendedPropertyValueExtensibleEnum tempVar = new ExtendedPropertyValueExtensibleEnum();
		tempVar.ExtendedPropertyValue = (int)extendedPropertyValue;
		return tempVar;
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion*/
}