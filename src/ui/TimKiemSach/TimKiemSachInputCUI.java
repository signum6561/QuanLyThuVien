package ui.TimKiemSach;

import java.util.Scanner;

import control.TimKiemSachControl;
import ui.util.Printer;

public class TimKiemSachInputCUI {
    private final Printer printer;
    private final Scanner sc;
    private final TimKiemSachControl timKiemSachControl;

    public TimKiemSachInputCUI(Printer printer, Scanner sc, TimKiemSachControl timKiemSachControl) {
        this.printer = printer;
        this.sc = sc;
        this.timKiemSachControl = timKiemSachControl;
    }

    public void nhapTieuChiTiemKiem() {
        printer.write("Tìm kiếm (mã sách, ngày nhập, nhà xuất bản): ");
        String pattern = sc.nextLine().trim();
        if(pattern.isEmpty()) {
            printer.error("Tiêu chí tìm kiếm không được để trống");
            return;
        }
        timKiem(pattern);
    }

    public void timKiem(String pattern) {
        timKiemSachControl.execute(pattern);
    }
}
