package application.entity;

import java.util.List;

public class LoaiSachChiTiet {
    private String tenLoai;
    private List<Sach> sachList;

    public LoaiSachChiTiet() {
    }

    public LoaiSachChiTiet(String tenLoai, List<Sach> sachList) {
        this.tenLoai = tenLoai;
        this.sachList = sachList;
    }

    public double tinhTrungBinhDonGia() {
        double sum = 0;
        int count = 0;
        for (Sach sach : sachList) {
            sum += sach.getDonGia();
            count++;
        }
        return sum / count;
    }
    
    public double tinhTongThanhTien() {
        double sum = 0;
        for (Sach sach : sachList) {
            sum += sach.tinhThanhTien();
        }
        return sum;
    }

    public int tinhSoLuong() {
        return sachList.size();
    }

    public double tinhTongDonGia() {
        double sum = 0;
        for (Sach sach : sachList) {
            sum += sach.getDonGia();
        }
        return sum;
    }

    public void addSach(Sach sach) {
        sachList.add(sach);
    }

    public String getTenLoai() {
        return this.tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public List<Sach> getSachList() {
        return this.sachList;
    }

    public void setSachList(List<Sach> sachList) {
        this.sachList = sachList;
    }
}
