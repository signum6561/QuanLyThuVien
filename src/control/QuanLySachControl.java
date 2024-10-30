package control;

import database.SachDatabaseMemory;
import entity.Sach;
import ui.UIConsoleOutput;

public class QuanLySachControl {
    private UIConsoleOutput uiOutput;
    private SachDatabaseMemory database;

    // Constructor rỗng
    public QuanLySachControl() {
    }

    // Constructor có tham số
    public QuanLySachControl(UIConsoleOutput uiOutput, SachDatabaseMemory database) {
        this.uiOutput = uiOutput;
        this.database = database;
    }

    // Các phương thức
    public void them(String ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        // Phần thân phương thức sẽ được triển khai sau
    }

    public void them(String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        // Phần thân phương thức sẽ được triển khai sau
    }

    public void sua(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        // Phần thân phương thức sẽ được triển khai sau
    }

    public void sua(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        // Phần thân phương thức sẽ được triển khai sau
    }

    public void xoa(String maSach) {
        // Phần thân phương thức sẽ được triển khai sau
    }

    public Sach timKiem(String maSach) {
        // Phần thân phương thức sẽ được triển khai sau
        return null; // Trả về null tạm thời
    }
}
