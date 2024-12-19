package test;

import application.control.LaySachControl;
import common.AppConstant;
import database.SachDatabaseFile;
import database.dao.LaySach.LaySachDAO;
import database.dao.LaySach.LaySachDAOFile;

public class LaySachTest {
    public static void main(String[] args) {
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_TEST_FILE_PATH);
        LaySachDAO laySachDAO = new LaySachDAOFile(dbFile);
        LaySachControl laySachControl = new LaySachControl(laySachDAO);
        
        laySachControl.execute("B-11111-22222");
        System.out.println(laySachControl.getResult());
        laySachControl.execute("12345");
        System.out.println(laySachControl.getResult());
    }
}
