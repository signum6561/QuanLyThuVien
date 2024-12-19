package test;

import java.util.Scanner;

import application.control.ThemSachControl;
import application.entity.Sach;
import common.util.IdGenerator;
import database.SachDatabaseMemory;
import database.dao.ThemSach.ThemSachDAO;
import database.dao.ThemSach.ThemSachDAOMemory;
import presentation.cui.ThemSach.ThemSachInputCUI;
import presentation.cui.ThemSach.ThemSachOutputCUI;
import presentation.cui.util.Printer;

public class ThemSachTest {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);

        IdGenerator idGenerator = new IdGenerator();
        ThemSachDAO themSachDAO = new ThemSachDAOMemory();
        ThemSachOutputCUI themSachOutputCUI = new ThemSachOutputCUI(printer);
        ThemSachControl themSachControl = new ThemSachControl(themSachOutputCUI, themSachDAO, idGenerator);
        ThemSachInputCUI themSachInputCUI = new ThemSachInputCUI(sc, printer, themSachControl);
        themSachInputCUI.nhapThongTinSach();

        for (Sach sach : SachDatabaseMemory.INSTANCE.selectAll()) {
            System.out.println(sach);
        }
    }
}
