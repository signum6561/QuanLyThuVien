package test;

import common.AppConstant;
import control.InChiTietSachControl;
import control.LaySachControl;
import control.LaySachDAO;
import control.TimMaSachControl;
import database.SachDatabaseFile;
import database.dao.LaySachDAOFile;
import ui.InChiTietSach.InChiTietSachOutputCUI;
import ui.TimMaSach.TimMaSachOutputCUI;
import ui.util.Printer;

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
