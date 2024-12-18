package test;

import common.AppConstant;
import control.LaySachControl;
import control.LaySachDAO;
import control.XoaSachControl;
import control.XoaSachDAO;
import database.SachDatabaseFile;
import database.dao.LaySachDAOFile;
import database.dao.XoaSachDAOFile;
import ui.XoaSach.XoaSachOutputCUI;
import ui.util.Printer;

public class XoaSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_TEST_FILE_PATH);
        LaySachDAO laySachDAO = new LaySachDAOFile(dbFile);
        LaySachControl laySachControl = new LaySachControl(laySachDAO);

        XoaSachDAO xoaSachDao = new XoaSachDAOFile(dbFile);
        XoaSachOutputCUI xoaSachOutputCUI = new XoaSachOutputCUI(printer);
        XoaSachControl xoaSachControl = new XoaSachControl(xoaSachDao, laySachControl, xoaSachOutputCUI);

        xoaSachControl.execute("B-11111-22222");
        xoaSachControl.execute("12345");
    }
}
