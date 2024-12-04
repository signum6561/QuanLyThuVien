package dto;

import java.time.LocalDate;

import common.LoaiSach;
import common.TinhTrang;

public class ThemSachInputDTO {
    private LoaiSach loaiSach;
    private LocalDate ngayNhap;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;
    private double thue;
    private TinhTrang tinhTrang;

    public ThemSachInputDTO() {
    }

    public ThemSachInputDTO(LoaiSach loaiSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue, TinhTrang tinhTrang) {
        this.loaiSach = loaiSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
        this.thue = thue;
        this.tinhTrang = tinhTrang;
    }

    public LocalDate getNgayNhap() {
        return this.ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public LoaiSach getLoaiSach() {
        return this.loaiSach;
    }

    public void setLoaiSach(LoaiSach loaiSach) {
        this.loaiSach = loaiSach;
    }

    public TinhTrang getTinhTrang() {
        return this.tinhTrang;
    }

    public void setTinhTrang(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getThue() {
        return this.thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaXuatBan() {
        return this.nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

}
