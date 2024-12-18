package ui.util;

import java.util.List;

import common.AppConstant;
import common.LoaiSach;
import dto.SachDTO;
import util.CurrencyFormatter;

public class TableSach extends ConsoleTable<SachDTO> {
    private static final String MA_SACH_HEADER = "Mã sách";
    private static final String LOAI_SACH_HEADER = "Loại sách";
    private static final String NGAY_NHAP_HEADER = "Ngày nhập";
    private static final String DON_GIA_HEADER = "Đơn giá";
    private static final String SO_LUONG_HEADER = "Số lượng";
    private static final String NHA_XUAT_BAN_HEADER = "Nhà xuất bản";
    private static final String THANH_TIEN_HEADER = "Thành tiền";
    private int maxMaSachWidth;
    private int maxNgayNhapWidth;
    private int maxDonGiaWidth;
    private int maxSoLuongWidth;
    private int maxNhaXuatBanWidth;
    private int maxThanhTienWidth;
    private int maxLoaiSachWidth;

    public TableSach(Printer printer) {
        super(printer);
    }

    public TableSach(List<SachDTO> items, Printer printer) {
        super(items, printer);
    }

    @Override
    protected void init() {
        setIndexEnabled(true);
        maxMaSachWidth = MA_SACH_HEADER.length();
        maxLoaiSachWidth = LOAI_SACH_HEADER.length();
        maxNgayNhapWidth = AppConstant.DEFAULT_DATE_FORMAT.length();
        maxDonGiaWidth = DON_GIA_HEADER.length();
        maxSoLuongWidth = SO_LUONG_HEADER.length();
        maxNhaXuatBanWidth = NHA_XUAT_BAN_HEADER.length();
        maxThanhTienWidth = THANH_TIEN_HEADER.length();

        for (LoaiSach loaiSach : LoaiSach.values) {
            maxLoaiSachWidth = Math.max(maxLoaiSachWidth, loaiSach.getName().length());
        }
    }

    @Override
    protected void adjustWidths() {
        if(items.size() > 0) {
            maxMaSachWidth = Math.max(maxMaSachWidth, items.get(0).getMaSach().length());
            for (SachDTO item : items) {
                maxDonGiaWidth = Math.max(maxDonGiaWidth, CurrencyFormatter.formatVND(item.getDonGia()).length());
                maxSoLuongWidth = Math.max(maxSoLuongWidth, String.valueOf(item.getSoLuong()).length());
                maxNhaXuatBanWidth = Math.max(maxNhaXuatBanWidth, item.getNhaXuatBan().length());
                maxThanhTienWidth = Math.max(maxThanhTienWidth, CurrencyFormatter.formatVND(item.getThanhTien()).length());
            }
        }
    }

    @Override
    protected StringBuilder getDivider() {
        return new StringBuilder()
            .append(getLine(maxMaSachWidth))
            .append(getLine(maxNgayNhapWidth))
            .append(getLine(maxDonGiaWidth))
            .append(getLine(maxSoLuongWidth))
            .append(getLine(maxNhaXuatBanWidth))
            .append(getLine(maxLoaiSachWidth))
            .append(getLine(maxThanhTienWidth));
    }

    @Override
    protected StringBuilder getHeaders() {
        return new StringBuilder()
            .append(getCell(MA_SACH_HEADER, maxMaSachWidth))
            .append(getCell(NGAY_NHAP_HEADER, maxNgayNhapWidth))
            .append(getCell(DON_GIA_HEADER, maxDonGiaWidth, Align.CENTER))
            .append(getCell(SO_LUONG_HEADER, maxSoLuongWidth, Align.CENTER))
            .append(getCell(NHA_XUAT_BAN_HEADER, maxNhaXuatBanWidth))
            .append(getCell(LOAI_SACH_HEADER, maxLoaiSachWidth))
            .append(getCell(THANH_TIEN_HEADER, maxThanhTienWidth, Align.CENTER));
    }

    @Override
    protected StringBuilder getRowData(SachDTO item) {
        return new StringBuilder()
            .append(getCell(item.getMaSach(), maxMaSachWidth))
            .append(getCell(item.getNgayNhap(), maxNgayNhapWidth))
            .append(getCell(CurrencyFormatter.formatVND(item.getDonGia()), maxDonGiaWidth, Align.RIGHT))
            .append(getCell(String.valueOf(item.getSoLuong()), maxSoLuongWidth, Align.CENTER))
            .append(getCell(item.getNhaXuatBan(), maxNhaXuatBanWidth))
            .append(getCell(item.getLoaiSach(), maxLoaiSachWidth))
            .append(getCell(CurrencyFormatter.formatVND(item.getThanhTien()), maxThanhTienWidth, Align.RIGHT));
    }
}
