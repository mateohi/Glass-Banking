package uy.infocorp.banking.glass.domain.ocr;

import android.util.Pair;

import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class PriceExtractor {

    public static String extractPrice(String text, List<String> symbols) {
        Set<Pair<String, Double>> possiblePrices = extractPossiblePrices(text, symbols);

        int matches = possiblePrices.size();

        if (matches == 0) {
            return null;
        } else if (matches == 1) {
            Pair<String, Double> pair = possiblePrices.iterator().next();
            return pair.first + " " + pair.second;
        } else {
            throw new RuntimeException("Unable to identify between several possible prices");
        }
    }

    private static Set<Pair<String, Double>> extractPossiblePrices(String text, List<String> symbols) {
        Set<Pair<String, Double>> values = Sets.newHashSet();

        for (String symbol : symbols) {
            if (text.contains(symbol)) {
                String[] subTexts = text.trim().split(Pattern.quote(symbol));

                for (String subText : subTexts) {
                    String value = subText.trim().split(Pattern.quote(" "))[0];

                    if (isNumber(value)) {
                        values.add(Pair.create(symbol, Double.parseDouble(value)));
                    }
                }
            }
        }
        return values;
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
