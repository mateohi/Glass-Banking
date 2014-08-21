package uy.infocorp.banking.glass.icbankingglass.service.integration.publicapi.common.dto;

public class DestinationCurrencyDTO {

    private String currencySymbol;
    private String currencyAlpha3Code;
    private String currencyId;
    private String currencyDescription;

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyAlpha3Code() {
        return currencyAlpha3Code;
    }

    public void setCurrencyAlpha3Code(String currencyAlpha3Code) {
        this.currencyAlpha3Code = currencyAlpha3Code;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyDescription() {
        return currencyDescription;
    }

    public void setCurrencyDescription(String currencyDescription) {
        this.currencyDescription = currencyDescription;
    }
}

