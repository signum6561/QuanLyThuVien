package common;

public enum TinhTrang {
    MOI,
    CU;

    private static final TinhTrang[] values = values();
    public static TinhTrang get(int ordinal) {
        return values[ordinal];
    }
}
