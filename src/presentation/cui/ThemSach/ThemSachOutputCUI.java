package presentation.cui.ThemSach;

import presentation.util.Printer;

public class ThemSachOutputCUI {
    private final Printer printer;
    private final String PARM_SUCCESS_THEM_SACH = "Them sach thanh cong! Ma sach: @id";

    public ThemSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    private String SUCCESS_THEM_SACH(String id) {
        return PARM_SUCCESS_THEM_SACH.replaceAll("@id", id);
    }

    public void thongBao(String maSach) {
        printer.success(SUCCESS_THEM_SACH(maSach));
    }
}
