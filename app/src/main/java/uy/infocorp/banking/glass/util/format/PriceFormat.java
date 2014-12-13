package uy.infocorp.banking.glass.util.format;

import java.text.NumberFormat;

import uy.infocorp.banking.glass.model.common.Price;

public class PriceFormat {

    private static final NumberFormat defaultFormat = NumberFormat.getNumberInstance();

    static {
        defaultFormat.setMinimumFractionDigits(0);
        defaultFormat.setMaximumFractionDigits(1);
    }

    public static String parseDefault(double amount) {
        return defaultFormat.format(amount);
    }

    public static String readable(Price price) {
        String symbol = price.getSymbol();
        double amount = price.getAmount();

        return symbol + " " + parseDefault(amount);
    }

    public static String convertion(Price from, Price to) {
        String fromCode = from.getAlpha3Code();
        String toCode = to.getAlpha3Code();

        return fromCode + " > " + toCode;
    }
}
