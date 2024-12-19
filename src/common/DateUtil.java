package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtil {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(AppConstant.DEFAULT_DATE_FORMAT);

    public static String format(LocalDate date) {
        return DATE_FORMATTER.format(date);
    }

    public static LocalDate parse(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public static boolean isDateFormatValid(String date) {
        try {
            DateUtil.DATE_FORMATTER.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
