package common;

public final class AppConstant {
    public static final String APP_NAME = "QuanLySach";
    public static final String APP_VERSION = "1.0";
    public static final String DB_FILE_PATH = "sach.db";

    public static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";
    public static final String CURRENCY_FORMAT = "#,###";
        
    public static final String PARAM_ERROR_UNKNOWN_COMMAND = "Lệnh không xác định \"@c\"";
    public static final String ERROR_UNKNOWN_COMMAND(String command) {
        return PARAM_ERROR_UNKNOWN_COMMAND.replaceAll("@c", command);
    }

    public static final String PARAM_INVALID_ARG = "Tham số không xác định \"@arg\"";
    public static final String ERROR_INVALID_ARG(String arg) {
        return PARAM_INVALID_ARG.replaceAll("@arg", arg);
    }
}
