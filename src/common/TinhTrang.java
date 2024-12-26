package common;

public enum TinhTrang {
    MOI("Mới"),
    CU("Cũ");
    
    private String name;

    private TinhTrang(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static final TinhTrang[] values = values();
    public static final int size = values.length;
    
    public static TinhTrang get(int ordinal) {
        return values[ordinal];
    }
}
