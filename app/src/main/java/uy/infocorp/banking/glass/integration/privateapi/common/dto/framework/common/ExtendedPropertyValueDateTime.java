package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

import java.util.Date;

public class ExtendedPropertyValueDateTime extends ExtendedPropertyValue {
    private final Date DATE_MIN_VALUE = new Date(Long.MIN_VALUE);
    private Date extendedPropertyValue = DATE_MIN_VALUE;

    public final Date getExtendedPropertyValue() {
        return extendedPropertyValue;
    }

    public final void setExtendedPropertyValue(Date value) {
        extendedPropertyValue = value;
    }
}