package control;

import java.util.List;

import dto.LoaiSachChiTietDTO;
import dto.ThongKeSachResponse;
import ui.ThongKeSach.ThongKeSachOutputCUI;

public class ThongKeSachControl {
    private final ThongKeSachOutputCUI thongKeSachOutputCUI;
    private final LayDSLoaiSachChiTietControl layDSLoaiSachChiTietControl;

    public ThongKeSachControl(ThongKeSachOutputCUI thongKeSachOutputCUI, LayDSLoaiSachChiTietControl layDSLoaiSachChiTietControl) {
        this.thongKeSachOutputCUI = thongKeSachOutputCUI;
        this.layDSLoaiSachChiTietControl= layDSLoaiSachChiTietControl;
    }
    
    public void execute() {
        layDSLoaiSachChiTietControl.execute();
        List<LoaiSachChiTietDTO> loaiSachChiTietList = layDSLoaiSachChiTietControl.getResult();
        ThongKeSachResponse response = new ThongKeSachResponse();
        response.setLoaiSachChiTietList(loaiSachChiTietList);
        int soLuong = 0;
        double tongDonGia = 0;
        double tongThanhTien = 0;
        for (LoaiSachChiTietDTO loaiSachChiTietDTO : loaiSachChiTietList) {
            soLuong += loaiSachChiTietDTO.getSoLuong();
            tongDonGia += loaiSachChiTietDTO.getTongDonGia();
            tongThanhTien += loaiSachChiTietDTO.getTongThanhTien();
        }
        response.setSoLuong(soLuong);
        response.setTrungBinhDonGia(soLuong != 0 ? tongDonGia / soLuong : 0);
        response.setTongThanhTien(tongThanhTien);
        thongKeSachOutputCUI.hienThiKetQua(response);
    }
}
