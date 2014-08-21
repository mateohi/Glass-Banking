package uy.infocorp.banking.glass.integration.publicapi.exchange;

import java.util.Arrays;
import java.util.List;

import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;

public class ExchangeRateService {

    public static List<ExchangeRateDTO> getExchangeRates() {
        ExchangeRateDTO[] rates = ExchangeRateClient.instance().getExchangeRates();

        return Arrays.asList(rates);
    }
}
