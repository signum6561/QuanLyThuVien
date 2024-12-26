package common;

public enum LoaiSach {
    GIAO_KHOA("Giáo khoa"),
    THAM_KHAO("Tham khảo");

    public static final LoaiSach[] values = values();
    public static final int size = values.length;
    private String name;

    private LoaiSach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static LoaiSach get(int ordinal) {
        return values[ordinal];
    }
}
