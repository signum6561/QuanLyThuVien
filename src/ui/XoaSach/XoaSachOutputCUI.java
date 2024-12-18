package ui.XoaSach;

import ui.util.Printer;

public class XoaSachOutputCUI {
    private final Printer printer;
    private final String SUCCESS_XOA_SACH = "Xóa sách thành công";
    private final String PARM_KHONG_TIM_THAY_SACH = "Không tìm thấy sách \"@id\"";

    public XoaSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    private String KHONG_TIM_THAY_SACH(String id) {
        return PARM_KHONG_TIM_THAY_SACH.replaceAll("@id", id);
    }

    public void thongBaoThanhCong() {
        printer.success(SUCCESS_XOA_SACH);
    }

    public void khongTimThaySach(String maSach) {
        printer.error(KHONG_TIM_THAY_SACH(maSach));;
    }
}
