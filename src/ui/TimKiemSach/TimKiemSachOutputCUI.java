package ui.TimKiemSach;

import java.util.List;

import dto.SachDTO;
import ui.util.Printer;
import ui.util.TableSach;

public class TimKiemSachOutputCUI {
    private final Printer printer;

    public TimKiemSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void hienThiKetQua(List<SachDTO> data) {
        TableSach tableSach = new TableSach(printer);
        tableSach.setItems(data);
        tableSach.show();
    }
}
