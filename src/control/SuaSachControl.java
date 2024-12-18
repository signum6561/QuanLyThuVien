package control;
import database.dao.SuaSachDAO;
import dto.SuaSachInputDTO;
import ui.SuaSach.SuaSachOutputCUI;
import dto.SuaSachInputDTO;
import control.LaySachControl;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import database.dao.LaySachDAO;

public class SuaSachControl {
    private SuaSachOutputCUI suaSachOutput;
    private SuaSachDAO suaSachDAO;
   

    public SuaSachControl(SuaSachDAO suaSachDAO, SuaSachOutputCUI suaSachOutput) {
        this.suaSachDAO = suaSachDAO;
        this.suaSachOutput = suaSachOutput;
    }

    public void execute(SuaSachInputDTO request) {
        Sach sach;
        switch(request.getLoaiSach()){
            case GIAO_KHOA:
                SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa();
                sachGiaoKhoa.setTinhTrang(request.getTinhTrang());
                sach=sachGiaoKhoa;
            break;
            case THAM_KHAO:
                SachThamKhao sachThamKhao = new SachThamKhao();
                sachThamKhao.setThue(request.getThue());
                sach=sachThamKhao;
            break;
            default:
                return;
        }
        sach.setMaSach(request.getMaSach());
        sach.setNgayNhap(request.getNgayNhap());
        sach.setDonGia(request.getDonGia());
        sach.setSoLuong(request.getSoLuong());
        sach.setNhaXuatBan(request.getNhaXuatBan());
        
        suaSachDAO.suaSach(sach);
        suaSachOutput.thongBaoSua("Đã sửa sách thành công");
}
}
