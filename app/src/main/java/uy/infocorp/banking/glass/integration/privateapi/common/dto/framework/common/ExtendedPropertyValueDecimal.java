package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

import java.math.BigDecimal;

public class ExtendedPropertyValueDecimal extends ExtendedPropertyValue {

    private BigDecimal extendedPropertyValue = new BigDecimal(0);

    public final BigDecimal getExtendedPropertyValue() {
        return extendedPropertyValue;
    }

    public final void setExtendedPropertyValue(BigDecimal value) {
        extendedPropertyValue = value;
    }
}