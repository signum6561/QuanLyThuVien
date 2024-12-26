package presentation.util;

import java.util.ArrayList;
import java.util.List;

import application.dto.SachChiTietDTO;
import common.CurrencyFormatter;
import common.DateUtil;

public class TableDetail extends ConsoleTable<Pair> {
    private int maxColumn1Width;
    private int maxColumn2Width;
    private int maxTitleWidth;
    private String title;
    private SachChiTietDTO sach;
    private Pair footerItem;

    public TableDetail(Printer printer) {
        super(printer);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSach(SachChiTietDTO sach) {
        this.sach = sach;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void adjustWidths() {
        List<Pair> items = new ArrayList<>();
        items.add(new Pair("Mã sách", sach.getMaSach()));
        items.add(new Pair("Ngày nhập", DateUtil.format(sach.getNgayNhap())));
        items.add(new Pair("Loại sách", sach.getLoaiSach().getName()));
        items.add(new Pair("Đơn giá", CurrencyFormatter.formatVND(sach.getDonGia())));
        items.add(new Pair("Số lượng", String.valueOf(sach.getSoLuong()))); 
        items.add(new Pair("Nhà xuất bản", sach.getNhaXuatBan()));
        switch (sach.getLoaiSach()) {
            case GIAO_KHOA:
                items.add(new Pair("Tình trạng", sach.getTinhTrang().getName()));
                break;
            case THAM_KHAO:
                items.add(new Pair("Thuế", String.valueOf(sach.getThue())));
                break;
            default:
                break;
        }
        footerItem = new Pair("Thành tiền", CurrencyFormatter.formatVND(sach.getThanhTien()));
        setItems(items);
        if(items.size() > 0) {
            for (Pair item : items) {
                maxColumn1Width = Math.max(maxColumn1Width, item.getKey().length());
                maxColumn2Width = Math.max(maxColumn2Width, item.getValue().length());
            }
        }
        maxColumn1Width = Math.max(maxColumn1Width, footerItem.getKey().length());
        maxColumn2Width = Math.max(maxColumn2Width, footerItem.getValue().length());
        maxTitleWidth = maxColumn1Width + maxColumn2Width + 3;
    }

    @Override
    protected StringBuilder getDivider() {
        return new StringBuilder()
            .append(getLine(maxColumn1Width))
            .append(getLine(maxColumn2Width));
    }

    @Override
    protected StringBuilder getRowData(Pair item) {
        return new StringBuilder()
            .append(getCell(item.getKey(), maxColumn1Width))
            .append(getCell(item.getValue(), maxColumn2Width));
    }

    @Override
    protected StringBuilder getHeaders() {
        return new StringBuilder()
            .append(getCell(title, maxTitleWidth, Align.CENTER));
    }

    private void printFooter() {
        printRow(new StringBuilder()
            .append(getCell(footerItem.getKey(), maxColumn1Width))
            .append(getCell(footerItem.getValue(), maxColumn2Width))
        );
    }

    private void printStartDivider() {
        printDivider(new StringBuilder()
            .append(getLine(maxTitleWidth))
        );
    }

    @Override
    public void show() {
        adjustWidths();
        printStartDivider();
        printHeader();
        printDivider();
        printBody();
        printDivider();
        printFooter();
        printDivider();
    }
}
