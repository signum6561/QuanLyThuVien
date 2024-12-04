package ui.ThemSach;

import ui.util.Printer;

public class ThemSachOutputCUI {
    private final Printer printer;

    public ThemSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void thongBao(String message) {
        printer.success(message + "\n");
    }
}
