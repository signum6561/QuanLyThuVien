package util;

import java.time.format.DateTimeFormatter;

import common.LoaiSach;
import common.TinhTrang;

public final class Validator {
    public static boolean isEmptyOrNull(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static boolean isLoaiSachIndexValid(int loaiSachIndex) {
        return loaiSachIndex >= 0 && loaiSachIndex < LoaiSach.values().length;
    }

    public static boolean isTinhTrangValid(int tinhTrang) {
        return tinhTrang >= 0 && tinhTrang < TinhTrang.values().length;
    }

    public static boolean isNgayNhapValid(String ngayNhap) {
        try {
            DateTimeFormatter.ofPattern("dd-MM-yyyy").parse(ngayNhap);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
