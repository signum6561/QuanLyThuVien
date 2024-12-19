package test;

import application.control.InChiTietSachControl;
import application.control.LaySachControl;
import application.control.TimMaSachControl;
import common.AppConstant;
import database.SachDatabaseFile;
import database.dao.LaySach.LaySachDAO;
import database.dao.LaySach.LaySachDAOFile;
import presentation.cui.InChiTietSach.InChiTietSachOutputCUI;
import presentation.cui.TimMaSach.TimMaSachOutputCUI;
import presentation.util.Printer;

public class InChiTietSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_TEST_FILE_PATH);

        LaySachDAO laySachDAO = new LaySachDAOFile(dbFile);
        LaySachControl laySachControl = new LaySachControl(laySachDAO);

        TimMaSachOutputCUI timMaSachOutputCUI = new TimMaSachOutputCUI(printer);
        TimMaSachControl timMaSachControl = new TimMaSachControl(laySachControl, timMaSachOutputCUI);

        InChiTietSachOutputCUI inChiTietSachOutputCUI = new InChiTietSachOutputCUI(printer);
        InChiTietSachControl inChiTietSachControl = new InChiTietSachControl(timMaSachControl, inChiTietSachOutputCUI);
        inChiTietSachControl.execute("B-11111-22222");
    }
}
