package ui;

import java.io.PrintWriter;
import java.util.Scanner;

import common.LoaiSach;
import common.TinhTrang;
import control.QuanLySachControl;
import util.Validator;

@Deprecated
public class UIConsoleInput {
    private Scanner sc;
    private QuanLySachControl sachControl;
    private PrintWriter writer;

    public UIConsoleInput(Scanner sc, PrintWriter writer, QuanLySachControl sachControl) {
        this.sc = sc;
        this.writer = writer;
        this.sachControl = sachControl;
    }

    public void xemDanhSach() {
        sachControl.inDanhSach();
    }

    public void xemThongTinSach() {
        writer.print("Nhap ma sach: "); writer.flush();
        String maSach = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(maSach)) {
            writer.println("Ma sach khong duoc de trong");
            return;
        }

        sachControl.inChiTiet(maSach);
    }

    public void themSach() {
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

        if(loaiSach == LoaiSach.GIAO_KHOA) {
            writer.print("Chon tinh trang(0-Moi, 1-Cu): "); writer.flush();
            int tinhTrangIndex = sc.nextInt(); sc.nextLine();
            if(!Validator.isTinhTrangValid(tinhTrangIndex)) {
                writer.println("Tinh trang khong chinh xac");
                return;
            }
            TinhTrang tinhTrang = TinhTrang.values()[tinhTrangIndex];

            sachControl.them(ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
        } else {
            writer.print("Nhap thue: "); writer.flush();
            String thueStr = sc.nextLine().trim();
            if(!Validator.isNumeric(thueStr)) {
                writer.println("Thue khong hop le");
                return;
            }
            double thue = Double.parseDouble(thueStr);

            sachControl.them(ngayNhap, donGia, soLuong, nhaXuatBan, thue);
        }
    }

    public void suaSach() {
        writer.print("Nhap ma sach: "); writer.flush();
        String maSach = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(maSach)) {
            writer.println("Ma sach khong duoc de trong");
            return;
        }
        if(sachControl.laySach(maSach) == null) {
            writer.println("Ma sach khong ton tai");
            return;
        }
        LoaiSach loaiSach = sachControl.laySach(maSach).getLoaiSach();

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

        if(loaiSach == LoaiSach.GIAO_KHOA) {
            writer.print("Chon tinh trang(0-Moi, 1-Cu): "); writer.flush();
            int tinhTrangIndex = sc.nextInt(); sc.nextLine();
            if(!Validator.isTinhTrangValid(tinhTrangIndex)) {
                writer.println("Tinh trang khong chinh xac");
                return;
            }
            TinhTrang tinhTrang = TinhTrang.values()[tinhTrangIndex];

            sachControl.sua(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
        } else {
            writer.print("Nhap thue: "); writer.flush();
            String thueStr = sc.nextLine().trim();
            if(!Validator.isNumeric(thueStr)) {
                writer.println("Thue khong hop le");
                return;
            }
            double thue = Double.parseDouble(thueStr);

            sachControl.sua(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, thue);
        }
    }

    public void timKiemSach() {
        writer.print("Tim kiem sach (ma sach, nha xuat ban, ngay nhap): "); writer.flush();
        String pattern = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(pattern)) {
            writer.println("Tieu chi tim kiem khong duoc de trong");
            return;
        }
        sachControl.timSach(pattern);
    }

    public void xoaSach() {
        writer.print("Nhap ma sach: "); writer.flush();
        String maSach = sc.nextLine().trim();
        if(Validator.isEmptyOrNull(maSach)) {
            writer.println("Ma sach khong duoc de trong");
            return;
        }
        sachControl.xoa(maSach);
    }

}
