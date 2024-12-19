package application.control;

import application.dto.ThemSachInputDTO;
import application.entity.Sach;
import application.entity.SachGiaoKhoa;
import application.entity.SachThamKhao;
import common.IdGenerator;
import database.dao.ThemSach.ThemSachDAO;
import presentation.cui.ThemSach.ThemSachOutputCUI;

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
        String id = idGenerator.generate();
        sach.setMaSach(id);
        sach.setNgayNhap(request.getNgayNhap());
        sach.setDonGia(request.getDonGia());
        sach.setSoLuong(request.getSoLuong());
        sach.setNhaXuatBan(request.getNhaXuatBan());
        themSachDao.themSach(sach);
        themSachOutput.thongBao(id);
    }
}
