package test;
import control.SuaSachControl;
import ui.SuaSach.SuaSachInputCUI;
import ui.SuaSach.SuaSachOutputCUI;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.PrintWriter;
import java.util.Scanner;
import ui.util.Printer;
import entity.Sach;
import database.SachDatabaseMemory;
import database.dao.SuaSachDAO;
import control.LaySachControl;
import database.dao.LaySachDAO;
public class SuaSachTest {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        PrintWriter printWriter = new PrintWriter(System.out, true, UTF_8);
        Printer printer = new Printer(printWriter);
        Scanner sc = new Scanner(System.in);
        SuaSachDAO suaSachDAO = new SuaSachDAO();
        LaySachDAO laySachDAO = new LaySachDAO();
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
