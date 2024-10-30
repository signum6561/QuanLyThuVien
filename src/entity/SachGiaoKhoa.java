package entity;

import java.time.LocalDate;

import common.LoaiSach;
import common.TinhTrang;

public class SachGiaoKhoa extends Sach {
    private TinhTrang tinhTrang;

    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong,
            String nhaXuatBan, TinhTrang tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    @Override
    public double tinhThanhTien() {
        double result = 0;
        if(tinhTrang == TinhTrang.Moi) {
            result = soLuong * donGia;
        } else {
            result = soLuong * donGia * 0.5;
        }
        return result;
    }

    @Override
    public LoaiSach getLoaiSach() {
        return LoaiSach.GiaoKhoa;
    }
}
