package ui;

import java.io.PrintWriter;
import java.util.List;

import common.LoaiSach;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

@Deprecated
public class UIConsoleOutput {
    private PrintWriter writer;

    public UIConsoleOutput(PrintWriter writer) {
        this.writer = writer;
    }

    public void hienThongTinSach(Sach sach) {
        if (sach != null) {
            writer.println("---------------------------");
            writer.println("Ma sach: " + sach.getMaSach());
            writer.println("Loai sach: " + sach.getLoaiSach());
            writer.println("Ngay nhap: " + sach.getNgayNhap());
            writer.println("Don gia: " + String.format("%.2f", sach.getDonGia()));
            writer.println("So luong: " + sach.getSoLuong());
            writer.println("Nha xuat ban: " + sach.getNhaXuatBan());
            if(sach.getLoaiSach() == LoaiSach.GIAO_KHOA) {
                writer.println("Tinh Trang: " + ((SachGiaoKhoa)sach).getTinhTrang());
            } else {
                writer.println("Thue: " + ((SachThamKhao)sach).getThue());
            }
            writer.println("Thanh tien: " + String.format("%.2f", sach.tinhThanhTien()));
        }
    }

    public void hienDanhSach(List<Sach> sachList) {
        // Determine maximum column widths
        int maxMaSachWidth = 12;
        int maxNgayNhapWidth = 15;
        int maxDonGiaWidth = 10;
        int maxSoLuongWidth = 10;
        int maxNhaXuatBanWidth = 20;

        for (Sach sach : sachList) {
            maxMaSachWidth = Math.max(maxMaSachWidth, sach.getMaSach().length());
            maxNgayNhapWidth = Math.max(maxNgayNhapWidth, sach.getNgayNhap().toString().length());
            maxDonGiaWidth = Math.max(maxDonGiaWidth, String.valueOf(sach.getDonGia()).length());
            maxSoLuongWidth = Math.max(maxSoLuongWidth, String.valueOf(sach.getSoLuong()).length());
            maxNhaXuatBanWidth = Math.max(maxNhaXuatBanWidth, sach.getNhaXuatBan().length());
        }

        // Adjust header width
        maxMaSachWidth = Math.max(maxMaSachWidth, "Ma Sach".length());
        maxNgayNhapWidth = Math.max(maxNgayNhapWidth, "Ngay Nhap".length());
        maxDonGiaWidth = Math.max(maxDonGiaWidth, "Don Gia".length());
        maxSoLuongWidth = Math.max(maxSoLuongWidth, "So Luong".length());
        maxNhaXuatBanWidth = Math.max(maxNhaXuatBanWidth, "Nha Xuat Ban".length());

        maxMaSachWidth += 3;
        maxNgayNhapWidth += 3;
        maxDonGiaWidth += 3;
        maxSoLuongWidth += 3;
        maxNhaXuatBanWidth += 3;

        // Print the table
        System.out.printf("%-" + maxMaSachWidth + "s|%-" + maxNgayNhapWidth + "s|%-" + maxDonGiaWidth + "s|%-" + maxSoLuongWidth + "s|%-" + maxNhaXuatBanWidth + "s\n",
                "Ma Sach", "Ngay Nhap", "Don Gia", "So Luong", "Nha Xuat Ban");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for (Sach sach : sachList) {
            System.out.printf("%-" + maxMaSachWidth + "s|%-" + maxNgayNhapWidth + "s|%-" + maxDonGiaWidth + ".2f|%-" + maxSoLuongWidth + "d|%-" + maxNhaXuatBanWidth + "s\n",
                    sach.getMaSach(), sach.getNgayNhap(), sach.getDonGia(), sach.getSoLuong(), sach.getNhaXuatBan());
        }
    }

    public void thongBao(String message) {
        writer.println("---------------------------");
        writer.println(message);
    }
}
