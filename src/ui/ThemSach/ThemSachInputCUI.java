package ui.ThemSach;

import java.io.PrintWriter;
import java.util.Scanner;

import common.LoaiSach;
import control.ThemSachControl;
import util.Validator;

public class ThemSachInputCUI {
    private Scanner sc;
    private PrintWriter writer;
    private ThemSachControl themSachControl;

    public ThemSachInputCUI(Scanner sc, PrintWriter writer, ThemSachControl themSachControl) {
        this.sc = sc;
        this.writer = writer;
        this.themSachControl = themSachControl;
    }

    public void nhapThongTinSach() {
        writer.print("Chon Loai Sach(0-Sach giao khoa, 1-Sach tham khao): "); writer.flush();
        int loaiSachIndex = sc.nextInt(); sc.nextLine();
        if(!Validator.isLoaiSachIndexValid(loaiSachIndex)) {
            writer.println("Loai sach khong chinh xac");
            return;
        }
        LoaiSach loaiSach = LoaiSach.values()[loaiSachIndex];

        writer.print("Nhap ngay nhap (dd-MM-yyyy): "); writer.flush();
        String ngayNhap = sc.nextLine().trim();
        if(!Validator.isNgayNhapValid(ngayNhap)) {
            writer.println("Ngay nhap khong dung dinh dang (dd-MM-yyyy).");
            return;
        }

        writer.print("Nhap don gia: "); writer.flush();
        String donGiaStr = sc.nextLine().trim();
        if(!Validator.isNumeric(donGiaStr)) {
            writer.println("Don gia khong hop le");
            return;
        }
        double donGia = Double.parseDouble(donGiaStr);

        writer.print("Nhap so luong: "); writer.flush();
        String soLuongStr = sc.nextLine().trim();
        if(!Validator.isNumeric(soLuongStr)) {
            writer.println("So luong khong hop le");
            return;
        }
        int soLuong = Integer.parseInt(soLuongStr);

        writer.print("Nhap nha xuat ban: "); writer.flush();
        String nhaXuatBan = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(nhaXuatBan)) {
            writer.println("Nha xuat ban khong duoc de trong");
            return;
        }
    }

}
