package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

import java.util.Date;

public class ExtendedPropertyValueDateTime extends ExtendedPropertyValue {

    private Date extendedPropertyValue = new Date(Long.MIN_VALUE);

    public final Date getExtendedPropertyValue() {
        return extendedPropertyValue;
    }

    public final void setExtendedPropertyValue(Date value) {
        extendedPropertyValue = value;
    }
}