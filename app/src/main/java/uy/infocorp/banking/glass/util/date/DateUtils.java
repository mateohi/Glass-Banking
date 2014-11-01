package uy.infocorp.banking.glass.util.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Date;

public class DateUtils {

    private static final DateTimeFormatter ISO_FORMAT = ISODateTimeFormat.dateTime();

    public static String dateToIsoString(Date date) {
        long dateInMillis = date.getTime();
        return ISO_FORMAT.print(dateInMillis);
    }

    public static String dateTimeToIsoString(DateTime date) {
        long dateInMillis = date.getMillis();
        return ISO_FORMAT.print(dateInMillis);
    }
}
