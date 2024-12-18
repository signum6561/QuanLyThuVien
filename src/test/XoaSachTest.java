package test;

import java.util.Scanner;

import common.AppConstant;
import control.LaySachControl;
import control.LaySachDAO;
import control.TimMaSachControl;
import control.XoaSachControl;
import control.XoaSachDAO;
import database.SachDatabaseFile;
import database.dao.LaySachDAOFile;
import database.dao.XoaSachDAOFile;
import ui.TimMaSach.TimMaSachOutputCUI;
import ui.XoaSach.XoaSachInputCUI;
import ui.XoaSach.XoaSachOutputCUI;
import ui.util.Printer;

public class XoaSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_TEST_FILE_PATH);
        LaySachDAO laySachDAO = new LaySachDAOFile(dbFile);
        LaySachControl laySachControl = new LaySachControl(laySachDAO);

        TimMaSachOutputCUI timMaSachOutputCUI = new TimMaSachOutputCUI(printer);
        TimMaSachControl timMaSachControl = new TimMaSachControl(laySachControl, timMaSachOutputCUI);

        XoaSachDAO xoaSachDao = new XoaSachDAOFile(dbFile);
        XoaSachOutputCUI xoaSachOutputCUI = new XoaSachOutputCUI(printer);
        XoaSachControl xoaSachControl = new XoaSachControl(xoaSachDao, timMaSachControl, xoaSachOutputCUI);
        XoaSachInputCUI xoaSachInputCUI = new XoaSachInputCUI(printer, sc, xoaSachControl);

        xoaSachControl.execute("B-11111-22222");
        xoaSachControl.execute("12345");
        xoaSachInputCUI.nhapMaSach();
    }
}
