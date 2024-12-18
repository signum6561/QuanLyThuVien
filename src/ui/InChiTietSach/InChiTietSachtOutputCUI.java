package ui.InChiTietSach;

import dto.SachChiTietDTO;
import ui.util.Printer;

public class InChiTietSachtOutputCUI {
    private final Printer printer;

    public InChiTietSachtOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void inChiTietSach(SachChiTietDTO dto) {
        printer.log("Chi tiết thông tin sách \"" + dto.getMaSach() + "\"");
        printField("Mã sách", dto.getMaSach());
        printField("Ngày nhập", dto.getNgayNhap());
        printField("Loại sách", dto.getLoaiSach());
        printField("Đơn giá", dto.getDonGia());
        printField("Số lượng", dto.getSoLuong());
        printField("Nhà xuất bản", dto.getNhaXuatBan());
        printField("Thành tiền", dto.getThanhTien());
    }

    private void printField(String label, Object value) {
        printer.format("%-20s %s", label, value);
    }
}
