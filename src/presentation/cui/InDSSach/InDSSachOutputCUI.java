package presentation.cui.InDSSach;

import java.util.List;

import application.dto.SachDTO;
import presentation.util.ConsoleTable;
import presentation.util.Printer;
import presentation.util.TableSach;

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
