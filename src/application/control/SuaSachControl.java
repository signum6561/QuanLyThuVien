package application.control;
import application.dto.SuaSachInputDTO;
import application.entity.Sach;
import application.entity.SachGiaoKhoa;
import application.entity.SachThamKhao;
import database.dao.SuaSach.SuaSachDAO;
import presentation.cui.SuaSach.SuaSachOutputCUI;

public class SuaSachControl {
    private SuaSachOutputCUI suaSachOutput;
    private SuaSachDAO suaSachDao;
   
    public SuaSachControl(SuaSachDAO suaSachDao, SuaSachOutputCUI suaSachOutput) {
        this.suaSachDao = suaSachDao;
        this.suaSachOutput = suaSachOutput;
    }

    public void execute(SuaSachInputDTO request) {
        Sach sach;
        switch(request.getLoaiSach()){
            case GIAO_KHOA:
                SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa();
                sachGiaoKhoa.setTinhTrang(request.getTinhTrang());
                sach = sachGiaoKhoa;
                break;
            case THAM_KHAO:
                SachThamKhao sachThamKhao = new SachThamKhao();
                sachThamKhao.setThue(request.getThue());
                sach = sachThamKhao;
                break;
            default:
                return;
        }
        sach.setMaSach(request.getMaSach());
        sach.setNgayNhap(request.getNgayNhap());
        sach.setDonGia(request.getDonGia());
        sach.setSoLuong(request.getSoLuong());
        sach.setNhaXuatBan(request.getNhaXuatBan());
        suaSachDao.suaSach(sach);
        suaSachOutput.thongBaoSua("Đã sửa sách thành công");
    }
}
