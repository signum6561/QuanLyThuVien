package ui.util;

import java.util.List;

import common.LoaiSach;
import dto.LoaiSachChiTietDTO;
import util.CurrencyFormatter;

public class TableThongKe extends ConsoleTable<LoaiSachChiTietDTO> {
    private static final String LOAI_SACH_HEADER = "Loại sách";
    private static final String SO_LUONG_HEADER = "Số lượng";
    private static final String TRUNG_BINH_DON_GIA_HEADER = "Trung bình đơn giá";
    private static final String TONG_THANH_TIEN_HEADER = "Tổng thành tiền";
    private int maxLoaiSachWidth;
    private int maxSoLuongWidth;
    private int maxTrungBinhDonGiaWidth;
    private int maxTongThanhTienWidth;
    private double tongThanhTien;
    private double trungBinhDonGia;
    private int soLuong;

    public TableThongKe(Printer printer) {
        super(printer);
    }

    public TableThongKe(List<LoaiSachChiTietDTO> items, Printer printer) {
        super(items, printer);
    }

    public void setTongThanhTien(double tongThanhTien) {
        this.tongThanhTien = tongThanhTien;
    }

    public void setTrungBinhDonGia(double trungBinhDonGia) {
        this.trungBinhDonGia = trungBinhDonGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    protected void init() {
        maxLoaiSachWidth = LOAI_SACH_HEADER.length();
        maxTrungBinhDonGiaWidth = TRUNG_BINH_DON_GIA_HEADER.length();
        maxTongThanhTienWidth = TONG_THANH_TIEN_HEADER.length();
        maxSoLuongWidth = SO_LUONG_HEADER.length();

        for (LoaiSach loaiSach : LoaiSach.values) {
            maxLoaiSachWidth = Math.max(maxLoaiSachWidth, loaiSach.getName().length());
        }
    }

    @Override
    protected void adjustWidths() {
        if(items.size() > 0) {
            maxSoLuongWidth = Math.max(maxSoLuongWidth, String.valueOf(soLuong).length());
            for (LoaiSachChiTietDTO item : items) {
                maxSoLuongWidth = Math.max(maxSoLuongWidth, String.valueOf(item.getSoLuong()).length());
                maxTrungBinhDonGiaWidth = Math.max(maxTrungBinhDonGiaWidth, CurrencyFormatter.formatVND(item.getTrungBinhDonGia()).length());
                maxTongThanhTienWidth = Math.max(maxTongThanhTienWidth, CurrencyFormatter.formatVND(item.getTongThanhTien()).length());
            }
        }
    }

    @Override
    protected StringBuilder getDivider() {
        return new StringBuilder()
            .append(getLine(maxLoaiSachWidth))
            .append(getLine(maxSoLuongWidth))
            .append(getLine(maxTrungBinhDonGiaWidth))
            .append(getLine(maxTongThanhTienWidth));
    }

    @Override
    protected StringBuilder getHeaders() {
        return new StringBuilder()
            .append(getCell(LOAI_SACH_HEADER, maxLoaiSachWidth))
            .append(getCell(SO_LUONG_HEADER, maxSoLuongWidth, Align.CENTER))
            .append(getCell(TRUNG_BINH_DON_GIA_HEADER, maxTrungBinhDonGiaWidth, Align.CENTER))
            .append(getCell(TONG_THANH_TIEN_HEADER, maxTongThanhTienWidth, Align.CENTER));
    }

    @Override
    protected StringBuilder getRowData(LoaiSachChiTietDTO item) {
        return new StringBuilder()
            .append(getCell(item.getTenLoai(), maxLoaiSachWidth))
            .append(getCell(String.valueOf(item.getSoLuong()), maxSoLuongWidth, Align.CENTER))
            .append(getCell(CurrencyFormatter.formatVND(item.getTrungBinhDonGia()), maxTrungBinhDonGiaWidth, Align.RIGHT))
            .append(getCell(CurrencyFormatter.formatVND(item.getTongThanhTien()), maxTongThanhTienWidth, Align.RIGHT));
    }

    @Override
    public void show() {
        super.show();
        printRow(new StringBuilder()
            .append(getCell("Tất cả", maxLoaiSachWidth))
            .append(getCell(String.valueOf(soLuong), maxSoLuongWidth, Align.CENTER))
            .append(getCell(CurrencyFormatter.formatVND(trungBinhDonGia), maxTrungBinhDonGiaWidth, Align.RIGHT))
            .append(getCell(CurrencyFormatter.formatVND(tongThanhTien), maxTongThanhTienWidth, Align.RIGHT))
        );
        printDivider();
    }
}
