package test;

import application.control.LayDSLoaiSachChiTietControl;
import application.control.ThongKeSachControl;
import database.SachDatabaseFile;
import database.dao.LayDSLoaiSachChiTiet.LayDSLoaiSachChiTietDAO;
import database.dao.LayDSLoaiSachChiTiet.LayDSLoaiSachChiTietDAOFile;
import presentation.cui.ThongKeSach.ThongKeSachOutputCUI;
import presentation.util.Printer;

public class ThongKeSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        SachDatabaseFile dbFile = new SachDatabaseFile();

        LayDSLoaiSachChiTietDAO layDSLoaiSachChiTietDAO = new LayDSLoaiSachChiTietDAOFile(dbFile);
        LayDSLoaiSachChiTietControl layDSLoaiSachChiTietControl = new LayDSLoaiSachChiTietControl(layDSLoaiSachChiTietDAO);
        ThongKeSachOutputCUI thongKeSachOutputCUI = new ThongKeSachOutputCUI(printer);
        ThongKeSachControl thongKeSachControl = new ThongKeSachControl(thongKeSachOutputCUI, layDSLoaiSachChiTietControl);
        thongKeSachControl.execute();
    }
}
