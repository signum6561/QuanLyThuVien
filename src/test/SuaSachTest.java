package test;
import java.util.Scanner;

import application.control.LaySachControl;
import application.control.SuaSachControl;
import application.control.TimMaSachControl;
import application.entity.Sach;
import database.SachDatabaseMemory;
import database.dao.LaySach.LaySachDAOMemory;
import database.dao.SuaSach.SuaSachDAO;
import database.dao.SuaSach.SuaSachDAOMemory;
import presentation.cui.SuaSach.SuaSachInputCUI;
import presentation.cui.SuaSach.SuaSachOutputCUI;
import presentation.cui.TimMaSach.TimMaSachOutputCUI;
import presentation.util.Printer;
public class SuaSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);

        for (Sach sach : SachDatabaseMemory.INSTANCE.selectAll()) {
            System.out.println(sach);
        }

        LaySachDAOMemory laySachDAO = new LaySachDAOMemory();
        LaySachControl laySachControl = new LaySachControl(laySachDAO);

        TimMaSachOutputCUI timMaSachOutputCUI = new TimMaSachOutputCUI(printer);
        TimMaSachControl timMaSachControl = new TimMaSachControl(laySachControl, timMaSachOutputCUI);

        SuaSachDAO suaSachDAO = new SuaSachDAOMemory();
        SuaSachOutputCUI suaSachOutput = new SuaSachOutputCUI(printer);
        SuaSachControl suaSachControl = new SuaSachControl(suaSachDAO, suaSachOutput);
        SuaSachInputCUI suaSachInputCUI = new SuaSachInputCUI(sc, timMaSachControl, printer, suaSachControl);
        suaSachInputCUI.nhapMaSach();

        for (Sach sach : SachDatabaseMemory.INSTANCE.selectAll()) {
            System.out.println(sach);
        }
    }
}
