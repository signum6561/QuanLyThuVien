package ui.InChiTietSach;

import java.util.Scanner;

import control.InChiTietSachControl;
import ui.util.Printer;

public class InChiTietSachInputCUI {
    private final Printer printer;
    private final Scanner sc;
    private final InChiTietSachControl inChiTietSachControl;

    public InChiTietSachInputCUI(Printer printer, Scanner sc, InChiTietSachControl inChiTietSachControl) {
        this.printer = printer;
        this.sc = sc;
        this.inChiTietSachControl = inChiTietSachControl;
    }

    public void nhapMaSach() {
        printer.write("Nhập mã sách: ");
        String maSach = sc.nextLine().trim();
        if(maSach.isEmpty()) {
            printer.error("Mã sách không được để trống");
            return;
        }
        inChiTietSach(maSach);
    }

    public void inChiTietSach(String maSach) {
        inChiTietSachControl.execute(maSach);
    }
}
