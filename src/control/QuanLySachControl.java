package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import common.TinhTrang;
import database.SachDatabaseMemory;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import ui.UIConsoleOutput;
import util.IdGenerator;

@Deprecated
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
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public void inDanhSach() {
        uiOutput.hienDanhSach(database.selectAll());
    }

    public void inChiTiet(String maSach) {
        Sach result = database.selectById(maSach);
        if(result != null) {            
            uiOutput.hienThongTinSach(result);
        } else {
            uiOutput.thongBao("Khong tim thay ma sach");
        }
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
        if(database.selectById(maSach) == null) {
            uiOutput.thongBao("Sua sach that bai! Ma sach khong ton tai");
            return;
        }
        LocalDate convertedNgayNhap = LocalDate.parse(ngayNhap, dateTimeFormatter);
        Sach sach = new SachGiaoKhoa(maSach, convertedNgayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
        database.update(sach);
        uiOutput.thongBao("Sua sach thanh cong!");
        uiOutput.hienThongTinSach(sach);
    }

    public void sua(String maSach, String ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        if(database.selectById(maSach) == null) {
            uiOutput.thongBao("Sua sach that bai! Ma sach khong ton tai");
            return;
        }
        LocalDate convertedNgayNhap = LocalDate.parse(ngayNhap, dateTimeFormatter);
        Sach sach = new SachThamKhao(maSach, convertedNgayNhap, donGia, soLuong, nhaXuatBan, thue);
        database.update(sach);
        uiOutput.thongBao("Sua sach thanh cong!");
        uiOutput.hienThongTinSach(sach);
    }

    public void xoa(String maSach) {
        if(database.selectById(maSach) == null) {
            uiOutput.thongBao("Xoa sach that bai! Ma sach khong ton tai");
            return;
        }
        database.delete(maSach);
        uiOutput.thongBao("Xoa thanh cong sach '" + maSach + "'");
    }

    public void timSach(String pattern) {
        List<Sach> result = database.selectByPattern(pattern);
        uiOutput.hienDanhSach(result);
    }

    public Sach laySach(String id) {
        return database.selectById(id);
    }
}
