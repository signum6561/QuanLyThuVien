import java.util.Scanner;

import common.AppConstant;
import control.InDSSachControl;
import control.InDSSachDAO;
import control.LayDSLoaiSachChiTietControl;
import control.LayDSLoaiSachChiTietDAO;
import control.ThemSachControl;
import control.ThemSachDAO;
import control.ThongKeSachControl;
import database.SachDatabaseFile;
import database.dao.InDSSachDAOFile;
import database.dao.LayDSLoaiSachChiTietDAOFile;
import database.dao.ThemSachDAOFile;
import ui.MenuCUI;
import ui.UserInputController;
import ui.InDSSach.InDSSachOutputCUI;
import ui.ThemSach.ThemSachInputCUI;
import ui.ThemSach.ThemSachOutputCUI;
import ui.ThongKeSach.ThongKeSachOutputCUI;
import ui.util.Printer;
import util.IdGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        SachDatabaseFile sachDatabaseFile = new SachDatabaseFile(AppConstant.DB_TEST_FILE_PATH);

        InDSSachDAO dsSachDAO = new InDSSachDAOFile(sachDatabaseFile);
        InDSSachOutputCUI inDSSachOutputCUI = new InDSSachOutputCUI(printer);
        InDSSachControl inDSSachControl = new InDSSachControl(inDSSachOutputCUI, dsSachDAO);

        ThemSachOutputCUI themSachOutputCUI = new ThemSachOutputCUI(printer);
        ThemSachDAO themSachDAO = new ThemSachDAOFile(sachDatabaseFile);
        IdGenerator idGenerator = new IdGenerator();
        ThemSachControl themSachControl = new ThemSachControl(themSachOutputCUI, themSachDAO, idGenerator);
        ThemSachInputCUI themSachInputCUI = new ThemSachInputCUI(sc, printer, themSachControl);

        LayDSLoaiSachChiTietDAO layDSLoaiSachChiTietDAO = new LayDSLoaiSachChiTietDAOFile(sachDatabaseFile);
        LayDSLoaiSachChiTietControl layDSLoaiSachChiTietControl = new LayDSLoaiSachChiTietControl(layDSLoaiSachChiTietDAO);
        ThongKeSachOutputCUI thongKeSachOutputCUI = new ThongKeSachOutputCUI(printer);
        ThongKeSachControl thongKeSachControl = new ThongKeSachControl(thongKeSachOutputCUI, layDSLoaiSachChiTietControl);

        MenuCUI menuCUI = new MenuCUI(printer);
        menuCUI.setInDSSachControl(inDSSachControl);
        menuCUI.setThemSachInputCUI(themSachInputCUI);
        menuCUI.setThongKeSachControl(thongKeSachControl);

        UserInputController userInputController = new UserInputController(sc, printer, menuCUI);
        userInputController.run();
    }
}
