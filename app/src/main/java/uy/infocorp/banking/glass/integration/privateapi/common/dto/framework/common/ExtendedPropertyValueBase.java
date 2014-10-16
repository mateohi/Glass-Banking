package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

public abstract class ExtendedPropertyValueBase {
    protected abstract ExtendedPropertyValueTypeAndValue getTypeAndValue();

    public final ExtendedPropertyValueType getType() {
        return getTypeAndValue().getType();
    }

    /*	@Override
        public boolean equals(Object obj)
        {
            boolean result = false;

            if (obj != null)
            {
                ExtendedPropertyValueBase extendedPropertyValueBase = (ExtendedPropertyValueBase)((obj instanceof ExtendedPropertyValueBase) ? obj : null);
                if (extendedPropertyValueBase != null)
                {
                    ExtendedPropertyValueTypeAndValue objTypeAndValue = extendedPropertyValueBase.getTypeAndValue();
                    if (objTypeAndValue != null)
                    {
                        ExtendedPropertyValueTypeAndValue thisTypeAndValue = getTypeAndValue();

                        result = objTypeAndValue.getType() == thisTypeAndValue.getType() && objTypeAndValue.getValue().equals(thisTypeAndValue.getValue());
                    }
                }
            }

            return result;
        }

        public final boolean equals(ExtendedPropertyValueBase other)
        {
            boolean result = false;

            if (other != null)
            {
                ExtendedPropertyValueTypeAndValue thisTypeAndValue = getTypeAndValue();
                ExtendedPropertyValueTypeAndValue otherTypeAndValue = other.getTypeAndValue();

                result = thisTypeAndValue.getType() == otherTypeAndValue.getType() && thisTypeAndValue.getValue().equals(otherTypeAndValue.getValue());
            }

            return result;
        }

        @Override
        public int hashCode()
        {
            return getTypeAndValue().getValue().hashCode();
        }

        @Override
        public String toString()
        {
            String result;

            ExtendedPropertyValueTypeAndValue typeAndValue = getTypeAndValue();
            if (typeAndValue.getType() == ExtendedPropertyValueType.ExtensibleEnum)
            {
                result = "";//String.format(CultureInfo.InvariantCulture, "ExtensibleEnum: %1$s", typeAndValue.getValue());
            }
            else
            {
                result = typeAndValue.getValue().toString();
            }

            return result;
        }

    *//*
    public static explicit operator String(ExtendedPropertyValueBase extendedPropertyValueBase)
	{
		return extendedPropertyValueBase.toString(null);
	}

	public static explicit operator int(ExtendedPropertyValueBase extendedPropertyValueBase)
	{
		return extendedPropertyValueBase.ToInt32(null);
	}

	public static explicit operator long(ExtendedPropertyValueBase extendedPropertyValueBase)
	{
		return extendedPropertyValueBase.ToInt64(null);
	}

	public static explicit operator java.math.BigDecimal(ExtendedPropertyValueBase extendedPropertyValueBase)
	{
		return extendedPropertyValueBase.ToDecimal(null);
	}

	public static explicit operator DateTime(ExtendedPropertyValueBase extendedPropertyValueBase)
	{
		return extendedPropertyValueBase.ToDateTime(null);
	}

	public static explicit operator boolean(ExtendedPropertyValueBase extendedPropertyValueBase)
	{
		return extendedPropertyValueBase.ToBoolean(null);
	}
*//*
	public static boolean OpEquality(ExtendedPropertyValueBase extendedPropertyValueBaseA, ExtendedPropertyValueBase extendedPropertyValueBaseB)
	{
		boolean result;

		if (extendedPropertyValueBaseA.equals(extendedPropertyValueBaseB))
		{
			result = true;
		}
		else
		{
			if (extendedPropertyValueBaseA == null || extendedPropertyValueBaseB == null)
			{
				result = false;
			}
			else
			{
				ExtendedPropertyValueTypeAndValue extendedPropertyValueBaseATypeAndValue = extendedPropertyValueBaseA.getTypeAndValue();
				ExtendedPropertyValueTypeAndValue extendedPropertyValueBaseBTypeAndValue = extendedPropertyValueBaseB.getTypeAndValue();

				result = extendedPropertyValueBaseATypeAndValue.getType() == extendedPropertyValueBaseBTypeAndValue.getType() && extendedPropertyValueBaseATypeAndValue.getValue().equals(extendedPropertyValueBaseBTypeAndValue.getValue());
			}
		}

		return result;
	}

	public static boolean OpInequality(ExtendedPropertyValueBase extendedPropertyValueBaseA, ExtendedPropertyValueBase extendedPropertyValueBaseB)
	{
		return !(ExtendedPropertyValueBase.OpEquality(extendedPropertyValueBaseA, extendedPropertyValueBaseB));
	}


	public final TypeCode GetTypeCode()
	{
		return (TypeCode)getTypeAndValue().getType();
	}

	public final boolean ToBoolean(IFormatProvider provider)
	{
		boolean result;

		ExtendedPropertyValueTypeAndValue typeAndValue = getTypeAndValue();
		if (typeAndValue.getType() == ExtendedPropertyValueType.Boolean)
		{
			result = (Boolean)typeAndValue.getValue();
		}
		else
		{
			throw GetInvalidTypeException(typeAndValue);
		}

		return result;
	}

	public final byte ToByte(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final char ToChar(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final java.time.LocalDateTime ToDateTime(IFormatProvider provider)
	{
		java.time.LocalDateTime result = java.time.LocalDateTime.MIN;

		ExtendedPropertyValueTypeAndValue typeAndValue = getTypeAndValue();
		if (typeAndValue.getType() == ExtendedPropertyValueType.DateTime)
		{
			result = (java.time.LocalDateTime)typeAndValue.getValue();
		}
		else
		{
			throw GetInvalidTypeException(typeAndValue);
		}

		return result;
	}

	public final java.math.BigDecimal ToDecimal(IFormatProvider provider)
	{
		java.math.BigDecimal result = new java.math.BigDecimal(0);

		ExtendedPropertyValueTypeAndValue typeAndValue = getTypeAndValue();
		if (typeAndValue.getType() == ExtendedPropertyValueType.Decimal)
		{
			result = (java.math.BigDecimal)typeAndValue.getValue();
		}
		else
		{
			throw GetInvalidTypeException(typeAndValue);
		}

		return result;
	}

	public final double ToDouble(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final short ToInt16(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final int ToInt32(IFormatProvider provider)
	{
		int result;

		ExtendedPropertyValueTypeAndValue typeAndValue = getTypeAndValue();
		if (typeAndValue.getType() == ExtendedPropertyValueType.Int32)
		{
			result = (Integer)typeAndValue.getValue();
		}
		else
		{
			throw GetInvalidTypeException(typeAndValue);
		}

		return result;
	}

	public final long ToInt64(IFormatProvider provider)
	{
		long result;

		ExtendedPropertyValueTypeAndValue typeAndValue = getTypeAndValue();
		if (typeAndValue.getType() == ExtendedPropertyValueType.Int64)
		{
			result = (Long)typeAndValue.getValue();
		}
		else
		{
			throw GetInvalidTypeException(typeAndValue);
		}

		return result;
	}

	public final byte ToSByte(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final float ToSingle(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final String toString(IFormatProvider provider)
	{
		String result;

		ExtendedPropertyValueTypeAndValue typeAndValue = getTypeAndValue();
		if (typeAndValue.getType() == ExtendedPropertyValueType.String)
		{
			result = (String)typeAndValue.getValue();
		}
		else
		{
			throw GetInvalidTypeException(typeAndValue);
		}

		return result;
	}

	public final Object ToType(java.lang.Class conversionType, IFormatProvider provider)
	{
		return Convert.ChangeType(getTypeAndValue().getValue(), conversionType, provider);
	}

	public final short ToUInt16(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final int ToUInt32(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final long ToUInt64(IFormatProvider provider)
	{
		throw GetInvalidTypeException(getTypeAndValue());
	}

	public final ExtensibleEnumBase ToExtensibleEnum(java.lang.Class extensibleEnumType)
	{
		return ExtensibleEnumBase.FromInt(extensibleEnumType, ToExtensibleEnumValue());
	}

	public final <T extends ExtensibleEnumBase> T ToExtensibleEnum()
	{
		return ExtensibleEnumBase.<T>FromInt(ToExtensibleEnumValue());
	}

	private int ToExtensibleEnumValue()
	{
		int result;

		ExtendedPropertyValueTypeAndValue typeAndValue = getTypeAndValue();
		if (typeAndValue.getType() == ExtendedPropertyValueType.ExtensibleEnum)
		{
			result = (Integer)typeAndValue.getValue();
		}
		else
		{
			throw GetInvalidTypeException(typeAndValue);
		}

		return result;
	}

	private UnsupportedOperationException GetInvalidTypeException(ExtendedPropertyValueTypeAndValue typeAndValue)
	{
		return new UnsupportedOperationException(String.format(CultureInfo.InvariantCulture, "ExtendedPropertyValue is of type \"%1$s\": \"%2$s\"", typeAndValue.getType(), typeAndValue.getValue()));
	}
*/
    protected static class ExtendedPropertyValueTypeAndValue {
        private ExtendedPropertyValueType privateType = ExtendedPropertyValueType.values()[0];

        public final ExtendedPropertyValueType getType() {
            return privateType;
        }

        public final void setType(ExtendedPropertyValueType value) {
            privateType = value;
        }

        private Object privateValue;

        public final Object getValue() {
            return privateValue;
        }

        public final void setValue(Object value) {
            privateValue = value;
        }
    }
}