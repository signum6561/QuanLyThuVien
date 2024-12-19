package presentation.cui.ThongKeSach;

import application.dto.ThongKeSachResponse;
import presentation.util.Printer;
import presentation.util.TableThongKe;

public class ThongKeSachOutputCUI {
    private final Printer printer;

    public ThongKeSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void hienThiKetQua(ThongKeSachResponse response) {
        TableThongKe tableThongKe = new TableThongKe(printer);
        tableThongKe.setItems(response.getLoaiSachChiTietList());
        tableThongKe.setTongThanhTien(response.getTongThanhTien());
        tableThongKe.setTrungBinhDonGia(response.getTrungBinhDonGia());
        tableThongKe.setSoLuong(response.getSoLuong());
        tableThongKe.show();
    }
}
