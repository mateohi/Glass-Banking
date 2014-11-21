package uy.infocorp.banking.glass.integration.publicapi.exchange;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.util.http.HttpUtils;

public class OfflineExchangeRateClient {

    private static final String OFFLINE_JSON = "[{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"32\",\"currencyAlpha3Code\":\"ARS\",\"currencyDescription\":\"Argentine peso\",\"currencySymbol\":\"$\"},\"buyRate\":4.49,\"sellRate\":5.26,\"official\":5.09},{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"840\",\"currencyAlpha3Code\":\"USD\",\"currencyDescription\":\"United States dollar\",\"currencySymbol\":\"US$\"},\"buyRate\":19.15,\"sellRate\":20.25,\"official\":19.95},{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"buyRate\":1.00,\"sellRate\":1.00,\"official\":1.00},{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"978\",\"currencyAlpha3Code\":\"EUR\",\"currencyDescription\":\"Euro\",\"currencySymbol\":\"€\"},\"buyRate\":25.10,\"sellRate\":33.33,\"official\":31.89},{\"sourceCurrency\":{\"currencyId\":\"858\",\"currencyAlpha3Code\":\"UYU\",\"currencyDescription\":\"Uruguayan peso\",\"currencySymbol\":\"$\"},\"destinationCurrency\":{\"currencyId\":\"986\",\"currencyAlpha3Code\":\"BRL\",\"currencyDescription\":\"Brazilian real\",\"currencySymbol\":\"R$\"},\"buyRate\":10.49,\"sellRate\":11.00,\"official\":10.50}]";

    public static List<ExchangeRateDTO> getExchangeRates() {
        ExchangeRateDTO[] exchangeRates = HttpUtils.typeFromStringData(OFFLINE_JSON, ExchangeRateDTO[].class);

        return Arrays.asList(exchangeRates);
    }
}
