package ui.util;

import java.util.List;
import java.util.Map;

import common.AppConstant;
import common.LoaiSach;
import entity.Sach;

public class TableSach {
    private static final String MA_SACH_HEADER = "Ma sach";
    private static final String LOAI_SACH_HEADER = "Loai sach";
    private static final String NGAY_NHAP_HEADER = "Ngay nhap";
    private static final String DON_GIA_HEADER = "Don gia";
    private static final String SO_LUONG_HEADER = "So luong";
    private static final String NHA_XUAT_BAN_HEADER = "Nha xuat ban";
    private static final String THANH_TIEN_HEADER = "Thanh tien";
    public static final Map<LoaiSach, String> loaiSachMapper = Map.of(
        LoaiSach.GIAO_KHOA, "Giao khoa",
        LoaiSach.THAM_KHAO, "Tham khao"
    );
    private int maxMaSachWidth;
    private int maxNgayNhapWidth;
    private int maxDonGiaWidth;
    private int maxSoLuongWidth;
    private int maxNhaXuatBanWidth;
    private int maxThanhTienWidth;
    private int maxLoaiSachWidth;

    private final Printer printer;
    private List<Sach> items;

    public TableSach(Printer printer) {
        this(null, printer);
    }

    public TableSach(List<Sach> items, Printer printer) {
        this.items = items;
        this.printer = printer;
        init();
    }

    public void setItems(List<Sach> items) {
        this.items = items;
    }

    private void init() {
        maxMaSachWidth = MA_SACH_HEADER.length();
        maxLoaiSachWidth = LOAI_SACH_HEADER.length();
        maxNgayNhapWidth = AppConstant.DEFAULT_DATE_FORMAT.length();
        maxDonGiaWidth = DON_GIA_HEADER.length();
        maxSoLuongWidth = SO_LUONG_HEADER.length();
        maxNhaXuatBanWidth = NHA_XUAT_BAN_HEADER.length();
        maxThanhTienWidth = THANH_TIEN_HEADER.length();

        for (String text : loaiSachMapper.values()) {
            maxLoaiSachWidth = Math.max(maxLoaiSachWidth, text.length());
        }
    }

    private void printDivider() {
        StringBuilder divider = new StringBuilder();
        divider.append(getLine(maxMaSachWidth));
        divider.append(getLine(maxNgayNhapWidth));
        divider.append(getLine(maxDonGiaWidth));
        divider.append(getLine(maxSoLuongWidth));
        divider.append(getLine(maxNhaXuatBanWidth));
        divider.append(getLine(maxLoaiSachWidth));
        divider.append(getLine(maxThanhTienWidth));
        divider.append("+");

        printer.log(divider.toString());
    }

    private void printHeader() {
        printer.format(getRowFormat() + "\n", 
            MA_SACH_HEADER, 
            NGAY_NHAP_HEADER, 
            DON_GIA_HEADER, 
            SO_LUONG_HEADER, 
            NHA_XUAT_BAN_HEADER, 
            LOAI_SACH_HEADER,
            THANH_TIEN_HEADER
        );
    }

    private void printBody() {
        String rowFormat = getRowFormat();
        for (Sach item : items) {
            printer.format(rowFormat + "\n", 
                item.getMaSach(), 
                item.getNgayNhap(), 
                item.getDonGia(), 
                item.getSoLuong(), 
                item.getNhaXuatBan(), 
                loaiSachMapper.get(item.getLoaiSach()), 
                item.tinhThanhTien()
            );
        }
    }

    private String getRowFormat() {
        StringBuilder rowFormat = new StringBuilder();
        rowFormat.append(getCellFormat(maxMaSachWidth));
        rowFormat.append(getCellFormat(maxNgayNhapWidth));
        rowFormat.append(getCellFormat(maxDonGiaWidth));
        rowFormat.append(getCellFormat(maxSoLuongWidth));
        rowFormat.append(getCellFormat(maxNhaXuatBanWidth));
        rowFormat.append(getCellFormat(maxLoaiSachWidth));
        rowFormat.append(getCellFormat(maxThanhTienWidth));
        rowFormat.append("|");
        return rowFormat.toString();
    }

    private String getCellFormat(int width) {
        return "| %-" + width + "s ";
    }

    private String getLine(int length) {
        length += 2;
        StringBuilder txt = new StringBuilder("+");
        while (length > 0) {
            txt.append("-");
            length--;   
        }
        return txt.toString();
    }

    private void adjustWidths() {
        if(items.size() > 0) {
            maxMaSachWidth = Math.max(maxMaSachWidth, items.get(0).getMaSach().length());
            for (Sach item : items) {
                maxDonGiaWidth = Math.max(maxDonGiaWidth, String.valueOf(item.getDonGia()).length());
                maxSoLuongWidth = Math.max(maxSoLuongWidth, String.valueOf(item.getSoLuong()).length());
                maxNhaXuatBanWidth = Math.max(maxNhaXuatBanWidth, item.getNhaXuatBan().length());
                maxThanhTienWidth = Math.max(maxThanhTienWidth, String.valueOf(item.tinhThanhTien()).length());
            }
        }
    }

    public void show() {
        adjustWidths();
        printDivider();
        printHeader();
        printDivider();
        printBody();
        printDivider();
    }
}
