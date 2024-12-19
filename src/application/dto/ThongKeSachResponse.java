package application.dto;

import java.util.List;

public class ThongKeSachResponse {
    private List<LoaiSachChiTietDTO> loaiSachChiTietList;
    private int soLuong;
    private double trungBinhDonGia;
    private double tongThanhTien;

    public ThongKeSachResponse() {
    }

    public List<LoaiSachChiTietDTO> getLoaiSachChiTietList() {
        return this.loaiSachChiTietList;
    }

    public void setLoaiSachChiTietList(List<LoaiSachChiTietDTO> loaiSachChiTietList) {
        this.loaiSachChiTietList = loaiSachChiTietList;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int tongSoLuong) {
        this.soLuong = tongSoLuong;
    }

    public double getTrungBinhDonGia() {
        return this.trungBinhDonGia;
    }

    public void setTrungBinhDonGia(double trungBinhDonGia) {
        this.trungBinhDonGia = trungBinhDonGia;
    }

    public double getTongThanhTien() {
        return this.tongThanhTien;
    }

    public void setTongThanhTien(double tongThanhTien) {
        this.tongThanhTien = tongThanhTien;
    }
}
