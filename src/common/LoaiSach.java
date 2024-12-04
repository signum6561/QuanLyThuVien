package common;

public enum LoaiSach {
    GIAO_KHOA,
    THAM_KHAO;

    private static final LoaiSach[] values = values();
    public static LoaiSach get(int ordinal) {
        return values[ordinal];
    }
}
