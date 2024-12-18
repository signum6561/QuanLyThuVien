package util;

import java.time.format.DateTimeFormatter;

import common.AppConstant;

public final class Validator {
    @Deprecated
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(AppConstant.DEFAULT_DATE_FORMAT);
    private static final String UNSIGNED_INTEGER_REGEX = "^[0-9]+$";
    private static final String UNSIGNED_DECIMAL_REGEX = "^[0-9]+(\\.[0-9]+)?$";

    public static boolean isEmptyOrNull(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static boolean isQuoted(String value) {
        return value.startsWith("\"") && value.endsWith("\"");
    }

    @Deprecated
    public static boolean isDateFormatValid(String date) {
        try {
            DateUtil.DATE_FORMATTER.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUnsignedInteger(String value) {
        return value.matches(UNSIGNED_INTEGER_REGEX);
    }

    public static boolean isUnsignedDecimal(String value) {
        return value.matches(UNSIGNED_DECIMAL_REGEX);
    }
}
