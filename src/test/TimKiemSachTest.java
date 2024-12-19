package test;

import java.util.Scanner;

import application.control.TimKiemSachControl;
import application.entity.Sach;
import common.AppConstant;
import database.SachDatabaseFile;
import database.dao.TimKiemSach.TimKiemSachDAO;
import database.dao.TimKiemSach.TimKiemSachDAOFile;
import presentation.cui.TimKiemSach.TimKiemSachInputCUI;
import presentation.cui.TimKiemSach.TimKiemSachOutputCUI;
import presentation.util.Printer;

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
