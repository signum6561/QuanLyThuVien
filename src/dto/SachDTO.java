package dto;

public class SachDTO {
    private String maSach;
    private String ngayNhap;
    private String loaiSach;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;
    private double thanhTien;

    public SachDTO() {
    }

    public String getMaSach() {
        return this.maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNgayNhap() {
        return this.ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getLoaiSach() {
        return this.loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
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

    public double getThanhTien() {
        return this.thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
