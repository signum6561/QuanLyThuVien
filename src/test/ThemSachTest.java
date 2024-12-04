package test;

import java.util.Scanner;

import control.ThemSachControl;
import database.SachDatabaseMemory;
import database.dao.ThemSachDAO;
import entity.Sach;
import ui.ThemSach.ThemSachInputCUI;
import ui.ThemSach.ThemSachOutputCUI;
import ui.util.Printer;
import util.IdGenerator;

public class ThemSachTest {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);

        IdGenerator idGenerator = new IdGenerator();
        ThemSachDAO themSachDAO = new ThemSachDAO();
        ThemSachOutputCUI themSachOutputCUI = new ThemSachOutputCUI(printer);
        ThemSachControl themSachControl = new ThemSachControl(themSachOutputCUI, themSachDAO, idGenerator);
        ThemSachInputCUI themSachInputCUI = new ThemSachInputCUI(sc, printer, themSachControl);
        themSachInputCUI.nhapThongTinSach();

        for (Sach sach : SachDatabaseMemory.INSTANCE.selectAll()) {
            System.out.println(sach);
        }
    }

}
