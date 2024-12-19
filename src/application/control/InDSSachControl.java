package application.control;

import java.util.ArrayList;
import java.util.List;

import application.dto.SachDTO;
import application.entity.Sach;
import database.dao.InDSSach.InDSSachDAO;
import presentation.cui.InDSSach.InDSSachOutputCUI;

public class InDSSachControl {
    private InDSSachOutputCUI inDSSachOutput;
    private InDSSachDAO inDsSachDao;

    public InDSSachControl(InDSSachOutputCUI inDSSachOutput, InDSSachDAO inDSSachDao) {
        this.inDSSachOutput = inDSSachOutput;
        this.inDsSachDao = inDSSachDao;
    }
    
    public void execute() {
        List<Sach> sachList = inDsSachDao.layDSSach();
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
        inDSSachOutput.inDanhSach(sachDTOs);
    }
}
