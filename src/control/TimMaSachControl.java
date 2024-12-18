package control;

import dto.SachChiTietDTO;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import ui.TimMaSach.TimMaSachOutputCUI;

public class TimMaSachControl {
    private final LaySachControl laySachControl;
    private final TimMaSachOutputCUI timMaSachOutput;
    private SachChiTietDTO result;

    public TimMaSachControl(LaySachControl laySachControl, TimMaSachOutputCUI timMaSachOutput) {
        this.laySachControl = laySachControl;
        this.timMaSachOutput = timMaSachOutput;
    }

    public void execute(String maSach) {
        this.result = null;
        laySachControl.execute(maSach);
        Sach sach = laySachControl.getResult();
        if(sach == null) {
            timMaSachOutput.khongTimThay(maSach);
            return;
        }
        SachChiTietDTO dto = new SachChiTietDTO();
        dto.setMaSach(sach.getMaSach());
        dto.setNgayNhap(sach.getNgayNhap());
        dto.setLoaiSach(sach.getLoaiSach());
        dto.setSoLuong(sach.getSoLuong());
        dto.setDonGia(sach.getDonGia());
        dto.setNhaXuatBan(sach.getNhaXuatBan());
        dto.setThanhTien(sach.tinhThanhTien());
        switch (sach.getLoaiSach()) {
            case GIAO_KHOA:
                SachGiaoKhoa sachGiaoKhoa = (SachGiaoKhoa) sach;
                dto.setTinhTrang(sachGiaoKhoa.getTinhTrang());
                break;
            case THAM_KHAO:
                SachThamKhao sachThamKhao = (SachThamKhao) sach;
                dto.setThue(sachThamKhao.getThue());
                break;
        }
        this.result = dto;
    }

    public SachChiTietDTO getResult() {
        return this.result;
    }

    public boolean isMaSachExist() {
        return this.result != null;
    }
}
