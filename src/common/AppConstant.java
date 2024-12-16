package common;

public final class AppConstant {
    public static final String APP_NAME = "QuanLySach";
    public static final String APP_VERSION = "1.0";

    public static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";
    public static final String CURRENCY_FORMAT = "#,###.00";
        
    public static final String PARAM_ERROR_UNKNOWN_COMMAND = "Lenh khong xac dinh \"@c\"";
    public static final String ERROR_UNKNOWN_COMMAND(String command) {
        return PARAM_ERROR_UNKNOWN_COMMAND.replaceAll("@c", command);
    }
}
