package ui.SuaSach;

import control.SuaSachControl;

import java.util.Map;
import java.util.Scanner;
import control.LaySachControl;
import ui.util.Printer;
import util.DateUtil;
import util.Validator;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import common.LoaiSach;
import common.TinhTrang;
import ui.util.InputMapper;
import dto.SuaSachInputDTO;

public class SuaSachInputCUI {
    
    private String  inp_ngayNhap, inp_donGia, inp_soLuong, inp_nhaXuatBan, inp_tinhTrang, inp_thue, inp_loaiSach;
    private final Scanner sc;
    private final LaySachControl laySachControl;
    private final Map<String, LoaiSach> loaiSachMapper = InputMapper.LOAI_SACH;
    private final Map<String, TinhTrang> tinhTrangMapper = InputMapper.TINH_TRANG;
    private final SuaSachControl suaSachControl;
    private final Printer printer;

    //constructor
    public SuaSachInputCUI( Scanner sc, LaySachControl laySachControl, Printer printer, SuaSachControl suaSachControl) {
        this.printer = printer;
        this.suaSachControl = suaSachControl;
        this.laySachControl= laySachControl;
        this.sc = sc;
    }

    //function
    public void nhapMaSach() {    
        printer.write ("Vui lòng nhập mã sách: ");
        String inp_maSach = sc.nextLine().trim();
        laySachControl.execute(inp_maSach);
        Sach sach = laySachControl.getResult();
        if (sach == null){
            printer.error("Mã sách không hợp lệ");
            return;
        }
        hienThiSachCu(sach);
        nhapThongTinSua();
    }

    public void hienThiSachCu(Sach sach){
        printer.log("Thông tin sách hiện tại:");
        printer.log("Ngày nhập sách là: "+ sach.getNgayNhap());
        printer.log("Đơn giá là: "+ sach.getDonGia());
        printer.log("Số lượng sách là: "+ sach.getSoLuong());
        printer.log("Nhà xuất bản là: "+ sach.getNhaXuatBan());      

        switch(sach.getLoaiSach()){
            case GIAO_KHOA:
                SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa();
                printer.log("Tình trạng là: "+ sachGiaoKhoa.getTinhTrang());
                break;
            case THAM_KHAO:
                SachThamKhao sachThamKhao = new SachThamKhao();
                printer.log("Thuế là: "+ sachThamKhao.getThue());
                break;
            default:
                return;
        }
    }

    public void nhapThongTinSua(){
        printer.write("Nhập ngày mới (dd-mm-yyyy): " );
        inp_ngayNhap = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_ngayNhap)) {
            printer.error("Ngày nhập không được để trống");
            return;
        }
        if(!DateUtil.isDateFormatValid(inp_ngayNhap)){
            printer.error("Ngày nhập không hợp lệ hoặc không đúng định dạng (dd-mm-yyyy) ");
            return;
        }

        printer.write("Nhập đơn giá mới: " );
        inp_donGia = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_donGia)) {
            printer.error("Đơn giá không được để trống");
            return;
        }
        if(!Validator.isUnsignedDecimal(inp_donGia)){
            printer.error("Đơn giá không hợp lệ");
            return;
        }

        printer.write("Nhập số lượng mới: ");
        inp_soLuong = sc.nextLine().trim();
        if (Validator.isEmptyOrNull(inp_soLuong)) {
            printer.error("Số lượng không được để trống");
            return;
        }
        if(!Validator.isUnsignedInteger(inp_soLuong)){
            printer.error("Số lượng không hợp lệ");
            return;
        }

        printer.write("Nhập nhà xuất bản mới: ");
        inp_nhaXuatBan = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(inp_nhaXuatBan)){
            printer.error("Nhà xuất bản không được đề trọng");
            return;
        }

        printer.write("Loại sách (0-Sách giáo khoa, 1-Sách tham khảo): ");
        inp_loaiSach = sc.nextLine().trim();
        LoaiSach loaiSach = loaiSachMapper.get(inp_loaiSach);
        if(loaiSach == null){
            printer.error("Loại sách không hợp lệ");
            return;
        }
        
        SuaSachInputDTO suaSachInputDTO = new SuaSachInputDTO();
        suaSachInputDTO.setLoaiSach(loaiSach);
        suaSachInputDTO.setNgayNhap(DateUtil.parse(inp_ngayNhap));
        suaSachInputDTO.setDonGia(Double.parseDouble(inp_donGia));
        suaSachInputDTO.setSoLuong(Integer.parseInt(inp_loaiSach));
        suaSachInputDTO.setNhaXuatBan(inp_nhaXuatBan);


        switch (loaiSach) {
            case GIAO_KHOA:
                printer.write("Tình trạng (0-Mới, 1-Cũ): ");
                inp_tinhTrang = sc.nextLine().trim();
                TinhTrang tinhTrang = tinhTrangMapper.get(inp_tinhTrang);
                if (tinhTrang == null) {
                    printer.error("Tình trạng không hợp lệ");
                    return;
                }
                suaSachInputDTO.setTinhTrang(tinhTrang);
                break;

            case THAM_KHAO:
                printer.write("Nhập thuế: ");
                inp_thue = sc.nextLine().trim();
                if(Validator.isEmptyOrNull(inp_thue)) {
                    printer.error("Thuế không được để trống");
                    return;
                }
                if(!Validator.isUnsignedDecimal(inp_thue)){
                    printer.error("Thuế không hợp lệ");
                    return;
                }
                suaSachInputDTO.setThue(Double.parseDouble(inp_thue));
                break;
            default:
                return;
        }
        suaSachControl.execute(suaSachInputDTO);
    }
}
