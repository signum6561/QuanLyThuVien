package presentation.cui.InChiTietSach;

import application.dto.SachChiTietDTO;
import presentation.util.Printer;
import presentation.util.TableDetail;

public class InChiTietSachOutputCUI {
    private final Printer printer;

    public InChiTietSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void inChiTietSach(SachChiTietDTO dto) {
        TableDetail tableDetail = new TableDetail(printer);
        tableDetail.setTitle("Thông tin chi tiết sách");
        tableDetail.setSach(dto);
        tableDetail.show();
    }
}
