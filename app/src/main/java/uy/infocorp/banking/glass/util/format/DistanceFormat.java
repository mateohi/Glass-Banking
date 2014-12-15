package uy.infocorp.banking.glass.util.format;

import java.text.NumberFormat;

public class DistanceFormat {

    private static NumberFormat distanceFormat = NumberFormat.getNumberInstance();

    static {
        distanceFormat.setMinimumFractionDigits(0);
        distanceFormat.setMaximumFractionDigits(1);
    }

    public static String from(double distance) {
        return distanceFormat.format(distance);
    }


}
