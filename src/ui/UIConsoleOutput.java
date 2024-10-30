package ui;

import java.io.PrintWriter;
import java.util.List;

import entity.Sach;

public class UIConsoleOutput {
    private PrintWriter writer;

    public UIConsoleOutput(PrintWriter writer) {
        this.writer = writer;
    }

    public void hienThongTinSach(Sach sach) {
        if (sach != null) {
            writer.println("Ma sach: " + sach.getMaSach());
            writer.println("Ngay nhap: " + sach.getNgayNhap());
            writer.println("Don gia: " + sach.getDonGia());
            writer.println("So luong: " + sach.getSoLuong());
            writer.println("Nha xuat ban: " + sach.getNhaXuatBan());
            writer.println("Thanh tien: " + sach.tinhThanhTien());
        }
    }

    public void hienDanhSach(List<Sach> danhSach) {
        if (danhSach == null || danhSach.isEmpty()) {
            writer.println("Danh sách sách trống.");
        } else {
            writer.println("Danh sách sách:");
            danhSach.forEach(sach -> {
               writer.println(sach); 
            });
        }
    }

    public void thongBao(String message) {
        writer.println(message);
    }
}
