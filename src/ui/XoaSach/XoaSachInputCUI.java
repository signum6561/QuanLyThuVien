package ui.XoaSach;

import java.util.Scanner;

import control.XoaSachControl;
import ui.util.Printer;

public class XoaSachInputCUI {
    private final Printer printer;
    private final Scanner sc;
    private final XoaSachControl xoaSachControl;

    public XoaSachInputCUI(Printer printer, Scanner sc, XoaSachControl xoaSachControl) {
        this.printer = printer;
        this.sc = sc;
        this.xoaSachControl = xoaSachControl;
    }

    public void nhapMaSach() {
        printer.write("Nhập mã sách cần xóa: ");
        String maSach = sc.nextLine().trim();
        if(maSach.isEmpty()) {
            printer.error("Mã sách không được để trống");
            return;
        }
        xoaSach(maSach);
    }

    public void xoaSach(String maSach) {
        xoaSachControl.execute(maSach);
    }
}
