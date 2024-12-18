package ui.InDSSach;

import java.util.List;

import dto.SachDTO;
import ui.util.ConsoleTable;
import ui.util.Printer;
import ui.util.TableSach;

public class InDSSachOutputCUI {
    private final Printer printer;

    public InDSSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void inDanhSach(List<SachDTO> sachList) {
        ConsoleTable<?> tableSach = new TableSach(sachList, printer);
        tableSach.show();
    }   
}
