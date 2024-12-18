package test;
import control.SuaSachControl;
import control.SuaSachDAO;
import control.TimMaSachControl;
import ui.SuaSach.SuaSachInputCUI;
import ui.SuaSach.SuaSachOutputCUI;
import ui.TimMaSach.TimMaSachOutputCUI;

import java.util.Scanner;
import ui.util.Printer;
import entity.Sach;
import database.SachDatabaseMemory;
import control.LaySachControl;
import database.dao.LaySachDAOMemory;
import database.dao.SuaSachDAOMemory;
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
