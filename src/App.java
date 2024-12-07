import java.util.Scanner;

import control.ThemSachControl;
import database.dao.ThemSachDAO;
import ui.MenuCUI;
import ui.ThemSach.ThemSachInputCUI;
import ui.ThemSach.ThemSachOutputCUI;
import ui.util.Printer;
import util.IdGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);

        ThemSachOutputCUI themSachOutputCUI = new ThemSachOutputCUI(printer);
        ThemSachDAO themSachDAO = new ThemSachDAO();
        IdGenerator idGenerator = new IdGenerator();
        ThemSachControl themSachControl = new ThemSachControl(themSachOutputCUI, themSachDAO, idGenerator);
        ThemSachInputCUI themSachInputCUI = new ThemSachInputCUI(sc, printer, themSachControl);

        MenuCUI menuCUI = new MenuCUI(sc, printer);
        menuCUI.setThemSachInputCUI(themSachInputCUI);

        menuCUI.run();
    }
}
