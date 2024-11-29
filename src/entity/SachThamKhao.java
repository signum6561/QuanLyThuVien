package entity;

import java.time.LocalDate;

import common.LoaiSach;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
    }

    public SachThamKhao(double thue) {
        this.thue = thue;
    }

    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong,
            String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    @Override
    public double tinhThanhTien() {
        return soLuong * donGia + thue;
    }

    @Override
    public LoaiSach getLoaiSach() {
        return LoaiSach.ThamKhao;
    }

    public double getThue() {
        return this.thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    @Override
    public String toString() {
        return "SachThamKhao [maSach=" + maSach + ", thue=" + thue + ", ngayNhap=" + ngayNhap + ", donGia=" + donGia
                + ", soLuong=" + soLuong + ", nhaXuatBan=" + nhaXuatBan + ", thanhTien=" + tinhThanhTien() + "]";
    }
}
