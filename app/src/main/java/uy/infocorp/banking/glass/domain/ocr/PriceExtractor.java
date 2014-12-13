package uy.infocorp.banking.glass.domain.ocr;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.regex.Pattern;

import uy.infocorp.banking.glass.model.common.Price;

public class PriceExtractor {

    public static Set<Price> extractPossiblePrices(String text, Set<String> symbols) {
        Set<Price> prices = Sets.newHashSet();

        for (String symbol : symbols) {
            if (text.contains(symbol)) {
                String[] subTexts = text.trim().split(Pattern.quote(symbol));

                for (String subText : subTexts) {
                    String value = subText.trim().split(Pattern.quote(" "))[0];

                    if (isNumber(value)) {
                        double amount = Double.parseDouble(value);

                        Price price = new Price();
                        price.setAmount(amount);
                        price.setSymbol(symbol);

                        prices.add(price);
                    }
                }
            }
        }
        return prices;
    }

    private static boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
