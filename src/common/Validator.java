package common;

public final class Validator {
    private static final String UNSIGNED_INTEGER_REGEX = "^[0-9]+$";
    private static final String UNSIGNED_DECIMAL_REGEX = "^[0-9]+(\\.[0-9]+)?$";

    public static boolean isEmptyOrNull(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static boolean isUnsignedInteger(String value) {
        return value.matches(UNSIGNED_INTEGER_REGEX);
    }

    public static boolean isUnsignedDecimal(String value) {
        return value.matches(UNSIGNED_DECIMAL_REGEX);
    }
}
