package presentation.cui.InChiTietSach;

import application.dto.SachChiTietDTO;
import common.CurrencyFormatter;
import common.DateUtil;
import presentation.util.Printer;

public class InChiTietSachOutputCUI {
    private final Printer printer;

    public InChiTietSachOutputCUI(Printer printer) {
        this.printer = printer;
    }

    public void inChiTietSach(SachChiTietDTO dto) {
        printer.log("Chi tiết thông tin sách \"" + dto.getMaSach() + "\"");
        printField("Mã sách", dto.getMaSach());
        printField("Ngày nhập", DateUtil.format(dto.getNgayNhap()));
        printField("Loại sách", dto.getLoaiSach().getName());
        printField("Đơn giá", CurrencyFormatter.formatVND(dto.getDonGia()));
        printField("Số lượng", dto.getSoLuong());
        printField("Nhà xuất bản", dto.getNhaXuatBan());
        printField("Thành tiền", CurrencyFormatter.formatVND(dto.getThanhTien()));
        switch (dto.getLoaiSach()) {
            case GIAO_KHOA:
                printField("Tình trạng", dto.getTinhTrang().getName());
                break;
            case THAM_KHAO:
                printField("Thuế", dto.getThue());
                break;
        }
    }

    private void printField(String label, Object value) {
        printer.format("%-20s %s\n", label, value);
    }
}
