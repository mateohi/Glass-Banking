package uy.infocorp.banking.glass.integration.publicapi.exchange;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.util.http.BaseClient;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.Resources;

public class ExchangeRateClient extends BaseClient {

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

    public List<ExchangeRateDTO> getExchangeRatesByAlpha3Code(final String alpha3Code) {
        return filterRates(new Predicate<ExchangeRateDTO>() {
            @Override
            public boolean apply(ExchangeRateDTO input) {
                String sourceAlpha3Code = input.getSourceCurrencyDTO().getCurrencyAlpha3Code();
                String destinationAlpha3Code = input.getDestinationCurrencyDTO().getCurrencyAlpha3Code();

                return sourceAlpha3Code.equals(alpha3Code) && !sourceAlpha3Code.equals(destinationAlpha3Code);
            }
        });
    }

    public List<ExchangeRateDTO> getExchangeRatesBySymbol(final String symbol) {
        return filterRates(new Predicate<ExchangeRateDTO>() {
            @Override
            public boolean apply(ExchangeRateDTO input) {
                return symbol.equals(input.getSourceCurrencyDTO().getCurrencySymbol());
            }
        });
    }

    public List<ExchangeRateDTO> getExchangeRates() {
        return (List<ExchangeRateDTO>) this.execute();
    }

    @Override
    protected Object getOffline() {
        ExchangeRateDTO[] exchangeRates = Resources.jsonToObject(R.raw.exchange_rates,
                ExchangeRateDTO[].class);
        return Arrays.asList(exchangeRates);
    }

    @Override
    protected Object getOnline() {
        ExchangeRateDTO[] exchangeRates = this.builder.execute(ExchangeRateDTO[].class);
        return Arrays.asList(exchangeRates);
    }

    private List<ExchangeRateDTO> filterRates(Predicate<ExchangeRateDTO> predicate) {
        Iterable<ExchangeRateDTO> filtered = Iterables.filter(getExchangeRates(), predicate);
        return Lists.newArrayList(filtered);
    }
}

