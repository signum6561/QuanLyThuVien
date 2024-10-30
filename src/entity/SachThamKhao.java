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
    
}
