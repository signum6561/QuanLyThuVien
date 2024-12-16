package ui.InDSSach;

import java.util.List;

import entity.Sach;
import ui.util.Printer;
import ui.util.TableSach;

public class InDSSachOutputCUI {
    private final Printer printer;

    public InDSSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void inDanhSach(List<Sach> sachList) {
        TableSach tableSach = new TableSach(sachList, printer);
        tableSach.show();
    }   
}
