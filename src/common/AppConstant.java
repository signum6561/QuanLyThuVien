package common;

import java.util.Map;

public final class AppConstant {
    public static final String APP_NAME = "QuanLySach";
    public static final String APP_VERSION = "1.0";

    public static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";
    public static final String CURRENCY_FORMAT = "#,###.00";
    public static final String SUCCESS_THEM_SACH = "Them sach thanh cong!";
    public static final Map<String, String> COMMANDS_DETAIL = Map.of(
        "help", "Ho tro su dung",
        "thuvien [tv]", "In danh sach tat ca cac sach trong thu vien",
        "detail [de]", "In thong tin chi tiet sach voi ma sach",
        "add", "Them sach",
        "update", "Sua sach",
        "delete", "Xoa sach",
        "find", "Tim kiem sach",
        "quit [!q]", "Thoat chuong trinh"
    );
        
    public static final String PARAM_ERROR_UNKNOWN_COMMAND = "Error: Unknown command @c";
    public static final String ERROR_UNKNOWN_COMMAND(String command) {
        return PARAM_ERROR_UNKNOWN_COMMAND.replaceAll("@c", command);
    }
}
