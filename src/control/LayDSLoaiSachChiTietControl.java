package control;

import java.util.ArrayList;
import java.util.List;

import dto.LoaiSachChiTietDTO;
import entity.LoaiSachChiTiet;

public class LayDSLoaiSachChiTietControl {
    private final LayDSLoaiSachChiTietDAO layDSLoaiSachChiTietDao;
    private List<LoaiSachChiTietDTO> result;

    public LayDSLoaiSachChiTietControl(LayDSLoaiSachChiTietDAO layDSLoaiSachChiTietDAO) {
        this.layDSLoaiSachChiTietDao = layDSLoaiSachChiTietDAO;
    }

    public void execute() {
        List<LoaiSachChiTiet> loaiSachChiTietList = layDSLoaiSachChiTietDao.layDSLoaiSachChiTiet();
        result = new ArrayList<>();
        loaiSachChiTietList.forEach(loaiSachChiTiet -> {
            LoaiSachChiTietDTO loaiSachChiTietDTO = new LoaiSachChiTietDTO();
            loaiSachChiTietDTO.setTenLoai(loaiSachChiTiet.getTenLoai());
            loaiSachChiTietDTO.setTrungBinhDonGia(loaiSachChiTiet.tinhTrungBinhDonGia());
            loaiSachChiTietDTO.setTongThanhTien(loaiSachChiTiet.tinhTongThanhTien());
            loaiSachChiTietDTO.setSoLuong(loaiSachChiTiet.tinhSoLuong());
            loaiSachChiTietDTO.setTongDonGia(loaiSachChiTiet.tinhTongDonGia());
            result.add(loaiSachChiTietDTO);
        });
    }

    public List<LoaiSachChiTietDTO> getResult() {
        return result;
    }
}
