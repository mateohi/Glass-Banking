package uy.infocorp.banking.glass.integration.publicapi.exchange;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.ResourceUtils;

public class ExchangeRateClient extends BaseClient{

    private static ExchangeRateClient instance;
    private RestExecutionBuilder builder;

    private ExchangeRateClient() {
        this.builder = RestExecutionBuilder.get(PublicUrls.GET_EXCHANGE_RATES_URL);
    }

    public static ExchangeRateClient instance() {
        if (instance == null) {
            instance = new ExchangeRateClient();
        }
        return instance;
    }

    public List<ExchangeRateDTO> getExchangeRatesByAlpha3Code(String alpha3Code) {
        List<ExchangeRateDTO> filteredRates = Lists.newArrayList();

        for (ExchangeRateDTO exchangeRate : this.getExchangeRates()) {
            String sourceAlpha3Code = exchangeRate.getSourceCurrencyDTO().getCurrencyAlpha3Code();
            String destinationAlpha3Code = exchangeRate.getDestinationCurrencyDTO().getCurrencyAlpha3Code();

            if (sourceAlpha3Code.equals(alpha3Code) && !sourceAlpha3Code.equals(destinationAlpha3Code)) {
                filteredRates.add(exchangeRate);
            }
        }

        return filteredRates;
    }

    public List<ExchangeRateDTO> getExchangeRates() {
        return (List<ExchangeRateDTO>)this.execute();
    }

    @Override
    public Object getOffline() {
        ExchangeRateDTO[] exchangeRates = ResourceUtils.jsonToObject(R.raw.exchange_rates,
                ExchangeRateDTO[].class);
        return Arrays.asList(exchangeRates);
    }

    @Override
    public Object getOnline() {
        ExchangeRateDTO[] exchangeRates = this.builder.execute(ExchangeRateDTO[].class);
        return Arrays.asList(exchangeRates);
    }
}

