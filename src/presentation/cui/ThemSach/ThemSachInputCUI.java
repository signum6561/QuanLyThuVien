package presentation.cui.ThemSach;

import java.util.Map;
import java.util.Scanner;

import application.control.ThemSachControl;
import application.dto.ThemSachInputDTO;
import common.LoaiSach;
import common.TinhTrang;
import common.util.DateUtil;
import common.util.Validator;
import presentation.cui.util.InputMapper;
import presentation.cui.util.Printer;

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
        printer.info("Vui lòng cung cấp thông tin sách cần thêm");
        printer.write("Ngày nhập (dd-MM-yyyy): ");
        inp_ngayNhap = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_ngayNhap)) {
            printer.error("Ngày nhập không được để trống");
            return;
        }
        if(!DateUtil.isDateFormatValid(inp_ngayNhap)) {
            printer.error("Ngày nhập không hợp lệ hoặc không đúng định dạng (dd-MM-yyyy)");
            return;
        }

        printer.write("Đơn giá: ");
        inp_donGia = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_donGia)) {
            printer.error("Đơn giá không được để trống");
            return;
        }
        if(!Validator.isUnsignedDecimal(inp_donGia)) {
            printer.error("Đơn giá không hợp lệ");
            return;
        }

        printer.write("Số lượng: ");
        inp_soLuong = sc.nextLine().trim();
        if (Validator.isEmptyOrNull(inp_soLuong)) {
            printer.error("Số lượng không được để trống");
            return;
        }
        if(!Validator.isUnsignedInteger(inp_soLuong)) {
            printer.error("Số lượng không hợp lệ");
            return;
        }

        printer.write("Nhà xuất bản: ");
        inp_nhaXuatBan = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_nhaXuatBan)) {
            printer.error("Nhà xuất bản không được để trống");
            return;
        }

        printer.write("Loại sách (0-Sách giáo khoa, 1-Sách tham khảo): ");
        inp_loaiSach = sc.nextLine().trim();
        LoaiSach loaiSach = loaiSachMapper.get(inp_loaiSach);
        if(loaiSach == null) {
            printer.error("Loại sách không hợp lệ");
            return;
        }

        ThemSachInputDTO themSachInputDTO = new ThemSachInputDTO();
        themSachInputDTO.setLoaiSach(loaiSach);
        themSachInputDTO.setNgayNhap(DateUtil.parse(inp_ngayNhap)); 
        themSachInputDTO.setDonGia(Double.parseDouble(inp_donGia));
        themSachInputDTO.setSoLuong(Integer.parseInt(inp_soLuong));
        themSachInputDTO.setNhaXuatBan(inp_nhaXuatBan);

        switch (loaiSach) {
            case GIAO_KHOA:
                printer.write("Tình trạng (0-Mới, 1-Cũ): ");
                inp_tinhTrang = sc.nextLine().trim();
                TinhTrang tinhTrang = tinhTrangMapper.get(inp_tinhTrang);
                if(tinhTrang == null) {
                    printer.error("Tình trạng không hợp lệ");
                    return;
                }

                themSachInputDTO.setTinhTrang(tinhTrang);
                break;
            case THAM_KHAO:
                printer.write("Thuế: ");
                inp_thue = sc.nextLine().trim();
                if(Validator.isEmptyOrNull(inp_thue)) {
                    printer.error("Thuế không được để trống");
                    return;
                }
                if(!Validator.isUnsignedDecimal(inp_thue)) {
                    printer.error("Thuế không hợp lệ");
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
