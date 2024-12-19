package application.dto;

import java.time.LocalDate;

import common.LoaiSach;
import common.TinhTrang;

public class SachChiTietDTO {
    private String maSach;
    private LocalDate ngayNhap;
    private LoaiSach loaiSach;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;
    private TinhTrang tinhTrang;
    private double thue;
    private double thanhTien;

    public String getMaSach() {
        return this.maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
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

    public double getThanhTien() {
        return this.thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
