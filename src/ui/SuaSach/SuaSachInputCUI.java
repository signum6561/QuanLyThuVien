package ui.SuaSach;

import control.SuaSachControl;
import control.TimMaSachControl;

import java.util.Map;
import java.util.Scanner;
import ui.util.Printer;
import util.CurrencyFormatter;
import util.DateUtil;
import util.Validator;
import common.LoaiSach;
import common.TinhTrang;
import ui.util.AnsiColors;
import ui.util.InputMapper;
import dto.SachChiTietDTO;
import dto.SuaSachInputDTO;

public class SuaSachInputCUI {
    
    private String  inp_ngayNhap, inp_donGia, inp_soLuong, inp_nhaXuatBan, inp_tinhTrang, inp_thue, inp_loaiSach;
    private final Scanner sc;
    private final TimMaSachControl timMaSachControl;
    private final Map<String, LoaiSach> loaiSachMapper = InputMapper.LOAI_SACH;
    private final Map<String, TinhTrang> tinhTrangMapper = InputMapper.TINH_TRANG;
    private final SuaSachControl suaSachControl;
    private final Printer printer;

    //constructor
    public SuaSachInputCUI( Scanner sc, TimMaSachControl timMaSachControl, Printer printer, SuaSachControl suaSachControl) {
        this.printer = printer;
        this.suaSachControl = suaSachControl;
        this.timMaSachControl= timMaSachControl;
        this.sc = sc;
    }

    public void nhapMaSach() {    
        printer.write ("Nhập mã sách cần sửa: ");
        String inp_maSach = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_maSach)) {
            printer.error("Mã sách không được để trống");
            return;
        }
        timSach(inp_maSach);
    }

    public void timSach(String maSach) {
        timMaSachControl.execute(maSach);
        if (!timMaSachControl.isMaSachExist()){
            return;
        }
        SachChiTietDTO sach = timMaSachControl.getResult();
        nhapThongTinSua(sach);
    }

    public void nhapThongTinSua(SachChiTietDTO sach) {
        SuaSachInputDTO suaSachInputDTO = new SuaSachInputDTO();
        printer.info("Vui lòng nhập thông tin mới, bỏ trống nếu không thay đổi");
        printLog("Ngày nhập (dd-MM-yyyy)", DateUtil.format(sach.getNgayNhap()));
        inp_ngayNhap = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_ngayNhap)) {
            suaSachInputDTO.setNgayNhap(sach.getNgayNhap());
        } else if(!DateUtil.isDateFormatValid(inp_ngayNhap)){
            printer.error("Ngày nhập không hợp lệ hoặc không đúng định dạng (dd-mm-yyyy) ");
            return;
        } else {
            suaSachInputDTO.setNgayNhap(DateUtil.parse(inp_ngayNhap));
        }

        printLog("Đơn giá", CurrencyFormatter.formatVND(sach.getDonGia()));
        inp_donGia = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_donGia)) {
            suaSachInputDTO.setDonGia(sach.getDonGia());
        } else if(!Validator.isUnsignedDecimal(inp_donGia)){
            printer.error("Đơn giá không hợp lệ");
            return;
        } else {
            suaSachInputDTO.setDonGia(Double.parseDouble(inp_donGia));
        }

        printLog("Số lượng", String.valueOf(sach.getSoLuong()));
        inp_soLuong = sc.nextLine().trim();
        if (Validator.isEmptyOrNull(inp_soLuong)) {
            suaSachInputDTO.setDonGia(sach.getDonGia());
        } else if(!Validator.isUnsignedInteger(inp_soLuong)){
            printer.error("Số lượng không hợp lệ");
            return;
        } else {
            suaSachInputDTO.setSoLuong(Integer.parseInt(inp_soLuong));
        }

        printLog("Nhà xuất bản", sach.getNhaXuatBan());
        inp_nhaXuatBan = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_nhaXuatBan)){
            suaSachInputDTO.setNhaXuatBan(sach.getNhaXuatBan());
        } else {
            suaSachInputDTO.setNhaXuatBan(inp_nhaXuatBan);
        }

        printLog("Loại sách (0-Sách giáo khoa, 1-Sách tham khảo)", sach.getLoaiSach().getName());
        inp_loaiSach = sc.nextLine().trim();
        LoaiSach loaiSach;
        if(inp_loaiSach.isEmpty()){
            loaiSach = sach.getLoaiSach();
        } else {
            loaiSach = loaiSachMapper.get(inp_loaiSach);
        }
        if(loaiSach == null){
            printer.error("Loại sách không hợp lệ");
            return;
        }
        suaSachInputDTO.setLoaiSach(loaiSach);

        switch (loaiSach) {
            case GIAO_KHOA:
                printLog("Tình trạng (0-Mới, 1-Cũ)", sach.getTinhTrang().getName());
                inp_tinhTrang = sc.nextLine().trim();
                TinhTrang tinhTrang;
                if(Validator.isEmptyOrNull(inp_tinhTrang)) {
                    tinhTrang = sach.getTinhTrang();
                } else {
                    tinhTrang = tinhTrangMapper.get(inp_tinhTrang);
                }
                if (tinhTrang == null) {
                    printer.error("Tình trạng không hợp lệ");
                    return;
                }
                suaSachInputDTO.setTinhTrang(tinhTrang);
                break;
            case THAM_KHAO:
                printLog("Thuế", String.valueOf(sach.getThue()));
                inp_thue = sc.nextLine().trim();
                if(Validator.isEmptyOrNull(inp_thue)) {
                    suaSachInputDTO.setThue(sach.getThue());
                } else if(!Validator.isUnsignedDecimal(inp_thue)){
                    printer.error("Thuế không hợp lệ");
                    return;
                } else {
                    suaSachInputDTO.setThue(Double.parseDouble(inp_thue));
                }
                break;
            default:
                return;
        }
        suaSachInputDTO.setMaSach(sach.getMaSach());
        suaSachControl.execute(suaSachInputDTO);
    }

    private void printLog(String label, String oldValue) {
        if (oldValue == null) {
            oldValue = "";
        }
        String field = label + ": " + printer.colorize(oldValue, AnsiColors.YELLOW_BRIGHT) + " ";
        printer.write(field);
    }
}
