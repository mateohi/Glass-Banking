package uy.infocorp.banking.glass.integration.publicapi.exchange.dto;


import uy.infocorp.banking.glass.integration.publicapi.common.dto.CurrencyDTO;

public class ExchangeRateDTO {

    private CurrencyDTO sourceCurrency;
    private CurrencyDTO destinationCurrency;

    private double buyRate;
    private double sellRate;
    private double official;

    public double getOfficial() {
        return official;
    }

    public void setOfficial(double official) {
        this.official = official;
    }

    public double getSellRate() {
        return sellRate;
    }

    public void setSellRate(double sellRate) {
        this.sellRate = sellRate;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(double buyRate) {
        this.buyRate = buyRate;
    }

    public CurrencyDTO getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(CurrencyDTO destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public CurrencyDTO getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(CurrencyDTO sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

}

