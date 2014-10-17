package uy.infocorp.banking.glass.integration.privateapi.common.dto.framework.common;

import java.util.Date;

import uy.infocorp.banking.glass.integration.privateapi.common.dto.Constants;

public class ExtendedPropertyValueDateTime extends ExtendedPropertyValue {
    private Date extendedPropertyValue = Constants.DATE_MIN_VALUE;

    public final Date getExtendedPropertyValue() {
        return extendedPropertyValue;
    }

    public final void setExtendedPropertyValue(Date value) {
        extendedPropertyValue = value;
    }
}