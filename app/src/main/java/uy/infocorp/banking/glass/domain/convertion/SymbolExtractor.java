package uy.infocorp.banking.glass.domain.convertion;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;

public class SymbolExtractor {

    public static Set<String> availableSymbols(List<ExchangeRateDTO> rates) {
        Set<String> symbols = Sets.newHashSet();
        for (ExchangeRateDTO rate : rates) {
            String symbol = rate.getSourceCurrency().getCurrencySymbol();
            symbols.add(symbol);
        }
        return symbols;
    }
}
