package control;

import common.AppConstant;
import database.dao.ThemSachDAO;
import dto.ThemSachInputDTO;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import ui.ThemSach.ThemSachOutputCUI;
import util.IdGenerator;

public class ThemSachControl {
    private final ThemSachOutputCUI themSachOutput;
    private final ThemSachDAO themSachDao;
    private final IdGenerator idGenerator;

    public ThemSachControl(ThemSachOutputCUI themSachOutput, ThemSachDAO themSachDao, IdGenerator idGenerator) {
        this.themSachOutput = themSachOutput;
        this.themSachDao = themSachDao;
        this.idGenerator = idGenerator;
    }

    public void execute(ThemSachInputDTO request) {
        Sach sach;
        switch (request.getLoaiSach()) {
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
        sach.setMaSach(idGenerator.generate());
        sach.setNgayNhap(request.getNgayNhap());
        sach.setDonGia(request.getDonGia());
        sach.setSoLuong(request.getSoLuong());
        sach.setNhaXuatBan(request.getNhaXuatBan());
        themSachDao.themSach(sach);
        themSachOutput.thongBao(AppConstant.SUCCESS_THEM_SACH);
    }
}
