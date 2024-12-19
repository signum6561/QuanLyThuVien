package test;

import java.util.Scanner;

import application.control.LaySachControl;
import application.control.TimMaSachControl;
import application.control.XoaSachControl;
import common.AppConstant;
import database.SachDatabaseFile;
import database.dao.LaySach.LaySachDAO;
import database.dao.LaySach.LaySachDAOFile;
import database.dao.XoaSach.XoaSachDAO;
import database.dao.XoaSach.XoaSachDAOFile;
import presentation.cui.TimMaSach.TimMaSachOutputCUI;
import presentation.cui.XoaSach.XoaSachInputCUI;
import presentation.cui.XoaSach.XoaSachOutputCUI;
import presentation.cui.util.Printer;

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
