package uy.infocorp.banking.glass.domain.convertion;

import android.util.Pair;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Set;

import uy.infocorp.banking.glass.integration.publicapi.common.dto.CurrencyDTO;
import uy.infocorp.banking.glass.integration.publicapi.exchange.dto.ExchangeRateDTO;
import uy.infocorp.banking.glass.model.common.Price;

public class PriceConvertor {

    public static List<Pair<Price, Price>> convertPrices(Set<Price> prices, List<ExchangeRateDTO> rates,
                                                   String convertionCode) {
        List<Pair<Price, Price>> convertions = Lists.newArrayList();
        for (Price price : prices) {
            String priceSymbol = price.getSymbol();
            ExchangeRateDTO appliedRate = getAppliedRate(rates, priceSymbol, convertionCode);

            if (appliedRate != null) {
                convertions.add(convert(price, appliedRate));
            }
        }
        return convertions;
    }

    private static Pair<Price, Price> convert(Price price, ExchangeRateDTO appliedRate) {
        CurrencyDTO source = appliedRate.getSourceCurrency();
        CurrencyDTO destination = appliedRate.getDestinationCurrency();

        Price from = new Price();
        from.setAmount(price.getAmount());
        from.setAlpha3Code(source.getCurrencyAlpha3Code());
        from.setSymbol(price.getSymbol());

        Price to = new Price();
        to.setAmount(price.getAmount() / appliedRate.getOfficial());
        to.setAlpha3Code(destination.getCurrencyAlpha3Code());
        to.setSymbol(destination.getCurrencySymbol());

        return Pair.create(from, to);
    }

    private static ExchangeRateDTO getAppliedRate(List<ExchangeRateDTO> rates, String priceSymbol,
                                           String convertionCode) {
        for (ExchangeRateDTO rate : rates) {
            String sourceSymbol = rate.getSourceCurrency().getCurrencySymbol();
            String destinationCode = rate.getDestinationCurrency().getCurrencyAlpha3Code();

            if (priceSymbol.equals(sourceSymbol) && convertionCode.equals(destinationCode)) {
                return rate;
            }
        }

        return null;
    }
}
