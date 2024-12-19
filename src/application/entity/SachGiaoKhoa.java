package application.entity;

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

    public SachGiaoKhoa(String ngayNhap, double donGia, int soLuong,
            String nhaXuatBan, TinhTrang tinhTrang) {
        super(null, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }
    

    @Override
    public double tinhThanhTien() {
        double result = 0;
        if(tinhTrang == TinhTrang.MOI) {
            result = soLuong * donGia;
        } else {
            result = soLuong * donGia * 0.5;
        }
        return result;
    }

    @Override
    public LoaiSach getLoaiSach() {
        return LoaiSach.GIAO_KHOA;
    }

    public TinhTrang getTinhTrang() {
        return this.tinhTrang;
    }

    public void setTinhTrang(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "SachGiaoKhoa [maSach=" + maSach + ", ngayNhap=" + ngayNhap + ", tinhTrang=" + tinhTrang + ", donGia="
                + donGia + ", soLuong=" + soLuong + ", nhaXuatBan=" + nhaXuatBan + ", thanhTien="
                + tinhThanhTien() + "]";
    }
}
