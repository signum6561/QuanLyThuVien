package control;

import java.util.ArrayList;
import java.util.List;

import dto.SachDTO;
import entity.Sach;
import ui.TimKiemSach.TimKiemSachOutputCUI;

public class TimKiemSachControl {
    private final TimKiemSachDAO timKiemSachDao;
    private final TimKiemSachOutputCUI timKiemSachOutput;

    public TimKiemSachControl(TimKiemSachDAO timKiemSachDao, TimKiemSachOutputCUI timKiemSachOutput) {
        this.timKiemSachDao = timKiemSachDao;
        this.timKiemSachOutput = timKiemSachOutput;
    }

    public void execute(String pattern) {
        List<Sach> sachList = timKiemSachDao.layKetQuaTimKiem(pattern);
        List<SachDTO> sachDTOs = new ArrayList<>();
        sachList.forEach(sach -> {
            SachDTO sachDTO = new SachDTO();
            sachDTO.setMaSach(sach.getMaSach());
            sachDTO.setNgayNhap(sach.getNgayNhap());
            sachDTO.setDonGia(sach.getDonGia());
            sachDTO.setSoLuong(sach.getSoLuong());
            sachDTO.setNhaXuatBan(sach.getNhaXuatBan());
            sachDTO.setThanhTien(sach.tinhThanhTien());
            sachDTO.setLoaiSach(sach.getLoaiSach().getName());
            sachDTOs.add(sachDTO);
        });
        timKiemSachOutput.hienThiKetQua(sachDTOs);
    }
}
