package presentation.cui.TimMaSach;

import presentation.cui.util.Printer;

public class TimMaSachOutputCUI {
    private final Printer printer;
    private final String PARM_KHONG_TIM_THAY_SACH = "Không tìm thấy sách \"@id\"";

    public TimMaSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    private String KHONG_TIM_THAY_SACH(String id) {
        return PARM_KHONG_TIM_THAY_SACH.replaceAll("@id", id);
    }

    public void khongTimThay(String maSach) {
        printer.error(KHONG_TIM_THAY_SACH(maSach));
    }
}
