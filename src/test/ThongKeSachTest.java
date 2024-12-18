package test;

import common.AppConstant;
import control.LayDSLoaiSachChiTietControl;
import control.LayDSLoaiSachChiTietDAO;
import control.ThongKeSachControl;
import database.SachDatabaseFile;
import database.dao.LayDSLoaiSachChiTietDAOFile;
import ui.ThongKeSach.ThongKeSachOutputCUI;
import ui.util.Printer;

public class ThongKeSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_FILE_PATH);

        LayDSLoaiSachChiTietDAO layDSLoaiSachChiTietDAO = new LayDSLoaiSachChiTietDAOFile(dbFile);
        LayDSLoaiSachChiTietControl layDSLoaiSachChiTietControl = new LayDSLoaiSachChiTietControl(layDSLoaiSachChiTietDAO);
        ThongKeSachOutputCUI thongKeSachOutputCUI = new ThongKeSachOutputCUI(printer);
        ThongKeSachControl thongKeSachControl = new ThongKeSachControl(thongKeSachOutputCUI, layDSLoaiSachChiTietControl);
        thongKeSachControl.execute();
    }
}
