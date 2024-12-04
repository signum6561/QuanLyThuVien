package util;

import java.time.format.DateTimeFormatter;

import common.AppConstant;
import common.LoaiSach;
import common.TinhTrang;

public final class Validator {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(AppConstant.DEFAULT_DATE_FORMAT);
    private static final String UNSIGNED_INTEGER_REGEX = "^[0-9]+$";
    private static final String UNSIGNED_DECIMAL_REGEX = "^[0-9]+(\\.[0-9]+)?$";

    public static boolean isEmptyOrNull(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static boolean isDateFormatValid(String date) {
        try {
            DATE_FORMATTER.parse(date);
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

    @Deprecated
    public static boolean isLoaiSachIndexValid(int loaiSachIndex) {
        return loaiSachIndex >= 0 && loaiSachIndex < LoaiSach.values().length;
    }

    @Deprecated
    public static boolean isTinhTrangValid(int tinhTrang) {
        return tinhTrang >= 0 && tinhTrang < TinhTrang.values().length;
    }

    @Deprecated
    public static boolean isNgayNhapValid(String ngayNhap) {
        try {
            DateTimeFormatter.ofPattern("dd-MM-yyyy").parse(ngayNhap);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Deprecated
    public static boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
