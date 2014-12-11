package uy.infocorp.banking.glass.util.format;

import java.text.NumberFormat;

public class PriceFormat {

    private static final NumberFormat defaultFormat = NumberFormat.getNumberInstance();

    static {
        defaultFormat.setMinimumFractionDigits(0);
        defaultFormat.setMaximumFractionDigits(1);
    }

    public static String parseDefault(double price) {
        return defaultFormat.format(price);
    }
}
