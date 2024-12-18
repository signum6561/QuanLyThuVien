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

    private static final TinhTrang[] values = values();
    
    public static TinhTrang get(int ordinal) {
        return values[ordinal];
    }
}
