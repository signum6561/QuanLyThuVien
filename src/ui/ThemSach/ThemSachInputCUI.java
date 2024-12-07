package ui.ThemSach;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import common.LoaiSach;
import common.TinhTrang;
import control.ThemSachControl;
import dto.ThemSachInputDTO;
import ui.util.InputMapper;
import ui.util.Printer;
import util.Validator;

public class ThemSachInputCUI {
    private final Scanner sc;

    private final Printer printer;

    private final ThemSachControl themSachControl;

    private String inp_loaiSach, inp_ngayNhap, inp_donGia, inp_soLuong, inp_nhaXuatBan, inp_thue, inp_tinhTrang;

    private final Map<String, LoaiSach> loaiSachMapper = InputMapper.LOAI_SACH;

    private final Map<String, TinhTrang> tinhTrangMapper = InputMapper.TINH_TRANG;

    public ThemSachInputCUI(Scanner sc, Printer printer, ThemSachControl themSachControl) {
        this.sc = sc;
        this.printer = printer;
        this.themSachControl = themSachControl;
    }

    public void nhapThongTinSach() {
        printer.info("Vui long cung cap thong tin sach can them");
        printer.write("Ngay nhap (dd-MM-yyyy): ");
        inp_ngayNhap = sc.nextLine().trim();
        if(!Validator.isDateFormatValid(inp_ngayNhap)) {
            printer.warning("Ngay nhap khong hop le hoac khong dung dinh dang (dd-MM-yyyy)");
            return;
        }

        printer.write("Don gia: ");
        inp_donGia = sc.nextLine().trim();
        if(!Validator.isUnsignedDecimal(inp_donGia)) {
            printer.warning("Don gia khong hop le");
            return;
        }

        printer.write("So luong: ");
        inp_soLuong = sc.nextLine().trim();
        if(!Validator.isUnsignedInteger(inp_soLuong)) {
            printer.warning("So luong khong hop le");
            return;
        }

        printer.write("Nha xuat ban: ");
        inp_nhaXuatBan = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_nhaXuatBan)) {
            printer.warning("Nha xuat ban khong duoc de trong");
            return;
        }

        printer.write("Loai sach (0-Sach giao khoa, 1-Sach tham khao): ");
        inp_loaiSach = sc.nextLine().trim();
        LoaiSach loaiSach = loaiSachMapper.get(inp_loaiSach);
        if(loaiSach == null) {
            printer.warning("Loai sach khong hop le");
            return;
        }

        ThemSachInputDTO themSachInputDTO = new ThemSachInputDTO();
        themSachInputDTO.setLoaiSach(loaiSach);
        themSachInputDTO.setNgayNhap(LocalDate.parse(inp_ngayNhap, Validator.DATE_FORMATTER));
        themSachInputDTO.setDonGia(Double.parseDouble(inp_donGia));
        themSachInputDTO.setSoLuong(Integer.parseInt(inp_loaiSach));
        themSachInputDTO.setNhaXuatBan(inp_nhaXuatBan);

        switch (loaiSach) {
            case GIAO_KHOA:
                printer.write("Tinh trang (0-Moi, 1-Cu): ");
                inp_tinhTrang = sc.nextLine().trim();
                TinhTrang tinhTrang = tinhTrangMapper.get(inp_tinhTrang);
                if(tinhTrang == null) {
                    printer.warning("Tinh trang khong hop le");
                    return;
                }

                themSachInputDTO.setTinhTrang(tinhTrang);
                break;
            case THAM_KHAO:
                printer.write("Thue: ");
                inp_thue = sc.nextLine().trim();
                if(!Validator.isUnsignedDecimal(inp_thue)) {
                    printer.warning("Thue khong hop le");
                    return;
                }

                themSachInputDTO.setThue(Double.parseDouble(inp_thue));
                break;
            default:
                return;
        }

        themSachControl.execute(themSachInputDTO);
    }
}
