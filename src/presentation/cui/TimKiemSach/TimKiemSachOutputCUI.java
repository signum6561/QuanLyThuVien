package presentation.cui.TimKiemSach;

import java.util.List;

import application.dto.SachDTO;
import presentation.util.Printer;
import presentation.util.TableSach;

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