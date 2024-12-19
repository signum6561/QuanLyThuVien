package application.dto;

public class LoaiSachChiTietDTO {
    private String tenLoai;
    private double trungBinhDonGia;
    private double tongThanhTien;
    private double tongDonGia;
    private int soLuong;

    public LoaiSachChiTietDTO() {
    }

    public LoaiSachChiTietDTO(String tenLoai, double trungBinhDonGia, double tongThanhTien, double tongDonGia, int soLuong) {
        this.tenLoai = tenLoai;
        this.trungBinhDonGia = trungBinhDonGia;
        this.tongThanhTien = tongThanhTien;
        this.tongDonGia = tongDonGia;
        this.soLuong = soLuong;
    }

    public String getTenLoai() {
        return this.tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
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

    public double getTongDonGia() {
        return this.tongDonGia;
    }

    public void setTongDonGia(double tongDonGia) {
        this.tongDonGia = tongDonGia;
    }

    public int getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
