package ui.XoaSach;

import ui.util.Printer;

public class XoaSachOutputCUI {
    private final Printer printer;
    private final String SUCCESS_XOA_SACH = "Xóa sách thành công";

    public XoaSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void thongBaoThanhCong() {
        printer.success(SUCCESS_XOA_SACH);
    }
}
