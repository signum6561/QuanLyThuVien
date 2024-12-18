package test;

import java.util.Scanner;

import common.AppConstant;
import control.TimKiemSachControl;
import control.TimKiemSachDAO;
import database.SachDatabaseFile;
import database.dao.TimKiemSachDAOFile;
import entity.Sach;
import ui.TimKiemSach.TimKiemSachInputCUI;
import ui.TimKiemSach.TimKiemSachOutputCUI;
import ui.util.Printer;

public class TimKiemSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_TEST_FILE_PATH);

        TimKiemSachDAO timKiemSachDAO = new TimKiemSachDAOFile(dbFile);
        TimKiemSachOutputCUI timKiemSachOutputCUI = new TimKiemSachOutputCUI(printer);
        TimKiemSachControl timKiemSachControl = new TimKiemSachControl(timKiemSachDAO, timKiemSachOutputCUI);
        TimKiemSachInputCUI timKiemSachInputCUI = new TimKiemSachInputCUI(printer, sc, timKiemSachControl);
        for (Sach sach : dbFile.readAll()) {
            System.out.println(sach);
        }
        timKiemSachInputCUI.nhapTieuChiTiemKiem();
    }
}
