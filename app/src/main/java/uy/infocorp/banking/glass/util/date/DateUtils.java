package uy.infocorp.banking.glass.util.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final DateFormat SIMPLE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateFormat SIMPLE_MONTH_DATE_FORMAT = new SimpleDateFormat("MMM dd");
    private static final DateTimeFormatter ISO_FORMAT = ISODateTimeFormat.dateTime();

    public static String dateToIsoString(Date date) {
        long dateInMillis = date.getTime();
        return ISO_FORMAT.print(dateInMillis);
    }

    public static String dateTimeToIsoString(DateTime date) {
        long dateInMillis = date.getMillis();
        return ISO_FORMAT.print(dateInMillis);
    }

    public static String simpleDateFormat(Date date) {
        return SIMPLE_FORMAT.format(date);
    }

    public static String simpleMonthDateFormat(Date date){
        return SIMPLE_MONTH_DATE_FORMAT.format(date);
    }
}
