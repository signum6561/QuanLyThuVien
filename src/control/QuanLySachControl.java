package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import common.TinhTrang;
import database.SachDatabaseMemory;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import ui.UIConsoleOutput;
import util.IdGenerator;

public class QuanLySachControl {
    private UIConsoleOutput uiOutput;
    private SachDatabaseMemory database;
    private IdGenerator idGenerator;
    private DateTimeFormatter dateTimeFormatter;

    public QuanLySachControl() {
    }

    public QuanLySachControl(UIConsoleOutput uiOutput, SachDatabaseMemory database, IdGenerator idGenerator) {
        this.uiOutput = uiOutput;
        this.database = database;
        this.idGenerator = idGenerator;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");;
    }

    public void them(String ngayNhap, double donGia, int soLuong, String nhaXuatBan, TinhTrang tinhTrang) {
        String maSach = idGenerator.generate();
        LocalDate convertedNgayNhap = LocalDate.parse(ngayNhap, dateTimeFormatter);
        Sach sach = new SachGiaoKhoa(maSach, convertedNgayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
        database.insert(sach);
        uiOutput.thongBao("Them sach thanh cong!");
        uiOutput.hienThongTinSach(sach);
    }

    public void them(String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        String maSach = idGenerator.generate();
        LocalDate convertedNgayNhap = LocalDate.parse(ngayNhap, dateTimeFormatter);
        Sach sach = new SachThamKhao(maSach, convertedNgayNhap, donGia, soLuong, nhaXuatBan, thue);
        database.insert(sach);
        uiOutput.thongBao("Them sach thanh cong!");
        uiOutput.hienThongTinSach(sach);
    }

    public void sua(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, TinhTrang tinhTrang) {
        LocalDate convertedNgayNhap = LocalDate.parse(ngayNhap, dateTimeFormatter);
        Sach sach = new SachGiaoKhoa(maSach, convertedNgayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
        database.update(sach);
        uiOutput.thongBao("Sua sach thanh cong!");
        uiOutput.hienThongTinSach(sach);
    }

    public void sua(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        LocalDate convertedNgayNhap = LocalDate.parse(ngayNhap, dateTimeFormatter);
        Sach sach = new SachThamKhao(maSach, convertedNgayNhap, donGia, soLuong, nhaXuatBan, thue);
        database.update(sach);
        uiOutput.thongBao("Sua sach thanh cong!");
        uiOutput.hienThongTinSach(sach);
    }

    public void xoa(String maSach) {
        database.delete(maSach);
        uiOutput.thongBao("Xoa thanh cong sach '" + maSach + "'");
    }

    public void timKiem(String maSach) {
        Sach result = database.selectById(maSach);
        if(result != null) {
            uiOutput.hienThongTinSach(result);
        } else {
            uiOutput.thongBao("Khong tim thay sach");
        }     
    }
}
