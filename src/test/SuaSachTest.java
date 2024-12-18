package test;
import control.SuaSachControl;
import ui.SuaSach.SuaSachInputCUI;
import ui.SuaSach.SuaSachOutputCUI;

import java.util.Scanner;
import ui.util.Printer;
import entity.Sach;
import database.SachDatabaseMemory;
import database.dao.SuaSachDAO;
import control.LaySachControl;
import database.dao.LaySachDAOMemory;
public class SuaSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        SuaSachDAO suaSachDAO = new SuaSachDAO();
        LaySachDAOMemory laySachDAO = new LaySachDAOMemory();
        LaySachControl laySachControl = new LaySachControl(laySachDAO);
        SuaSachOutputCUI suaSachOutput = new SuaSachOutputCUI(printer);
        SuaSachControl suaSachControl = new SuaSachControl(suaSachDAO, suaSachOutput);
        SuaSachInputCUI suaSachInputCUI = new SuaSachInputCUI(sc, laySachControl, printer, suaSachControl);
        suaSachInputCUI.nhapMaSach();
        
        for (Sach sach : SachDatabaseMemory.INSTANCE.selectAll()) {
            System.out.println(sach);
        }
    }
}
