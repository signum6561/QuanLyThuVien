import java.util.Scanner;

import common.AppConstant;
import control.InDSSachControl;
import control.InDSSachDAO;
import control.LayDSLoaiSachChiTietControl;
import control.LayDSLoaiSachChiTietDAO;
import control.LaySachControl;
import control.LaySachDAO;
import control.SuaSachControl;
import control.SuaSachDAO;
import control.ThemSachControl;
import control.ThemSachDAO;
import control.ThongKeSachControl;
import control.TimKiemSachControl;
import control.TimKiemSachDAO;
import control.TimMaSachControl;
import control.XoaSachControl;
import control.XoaSachDAO;
import database.SachDatabaseFile;
import database.dao.InDSSachDAOFile;
import database.dao.LayDSLoaiSachChiTietDAOFile;
import database.dao.LaySachDAOFile;
import database.dao.SuaSachDAOFile;
import database.dao.ThemSachDAOFile;
import database.dao.TimKiemSachDAOFile;
import database.dao.XoaSachDAOFile;
import ui.MenuCUI;
import ui.UserInputController;
import ui.InDSSach.InDSSachOutputCUI;
import ui.SuaSach.SuaSachInputCUI;
import ui.SuaSach.SuaSachOutputCUI;
import ui.ThemSach.ThemSachInputCUI;
import ui.ThemSach.ThemSachOutputCUI;
import ui.ThongKeSach.ThongKeSachOutputCUI;
import ui.TimKiemSach.TimKiemSachInputCUI;
import ui.TimKiemSach.TimKiemSachOutputCUI;
import ui.TimMaSach.TimMaSachOutputCUI;
import ui.XoaSach.XoaSachInputCUI;
import ui.XoaSach.XoaSachOutputCUI;
import ui.util.Printer;
import util.IdGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        SachDatabaseFile dbFile = new SachDatabaseFile(AppConstant.DB_TEST_FILE_PATH);

        InDSSachDAO dsSachDAO = new InDSSachDAOFile(dbFile);
        InDSSachOutputCUI inDSSachOutputCUI = new InDSSachOutputCUI(printer);
        InDSSachControl inDSSachControl = new InDSSachControl(inDSSachOutputCUI, dsSachDAO);

        ThemSachOutputCUI themSachOutputCUI = new ThemSachOutputCUI(printer);
        ThemSachDAO themSachDAO = new ThemSachDAOFile(dbFile);
        IdGenerator idGenerator = new IdGenerator();
        ThemSachControl themSachControl = new ThemSachControl(themSachOutputCUI, themSachDAO, idGenerator);
        ThemSachInputCUI themSachInputCUI = new ThemSachInputCUI(sc, printer, themSachControl);

        LaySachDAO laySachDAO = new LaySachDAOFile(dbFile);
        LaySachControl laySachControl = new LaySachControl(laySachDAO);

        TimMaSachOutputCUI timMaSachOutputCUI = new TimMaSachOutputCUI(printer);
        TimMaSachControl timMaSachControl = new TimMaSachControl(laySachControl, timMaSachOutputCUI);

        LayDSLoaiSachChiTietDAO layDSLoaiSachChiTietDAO = new LayDSLoaiSachChiTietDAOFile(dbFile);
        LayDSLoaiSachChiTietControl layDSLoaiSachChiTietControl = new LayDSLoaiSachChiTietControl(layDSLoaiSachChiTietDAO);

        SuaSachDAO suaSachDAO = new SuaSachDAOFile(dbFile);
        SuaSachOutputCUI suaSachOutput = new SuaSachOutputCUI(printer);
        SuaSachControl suaSachControl = new SuaSachControl(suaSachDAO, suaSachOutput);
        SuaSachInputCUI suaSachInputCUI = new SuaSachInputCUI(sc, timMaSachControl, printer, suaSachControl);

        XoaSachDAO xoaSachDao = new XoaSachDAOFile(dbFile);
        XoaSachOutputCUI xoaSachOutputCUI = new XoaSachOutputCUI(printer);
        XoaSachControl xoaSachControl = new XoaSachControl(xoaSachDao, timMaSachControl, xoaSachOutputCUI);
        XoaSachInputCUI xoaSachInputCUI = new XoaSachInputCUI(printer, sc, xoaSachControl);

        TimKiemSachDAO timKiemSachDAO = new TimKiemSachDAOFile(dbFile);
        TimKiemSachOutputCUI timKiemSachOutputCUI = new TimKiemSachOutputCUI(printer);
        TimKiemSachControl timKiemSachControl = new TimKiemSachControl(timKiemSachDAO, timKiemSachOutputCUI);
        TimKiemSachInputCUI timKiemSachInputCUI = new TimKiemSachInputCUI(printer, sc, timKiemSachControl);

        ThongKeSachOutputCUI thongKeSachOutputCUI = new ThongKeSachOutputCUI(printer);
        ThongKeSachControl thongKeSachControl = new ThongKeSachControl(thongKeSachOutputCUI, layDSLoaiSachChiTietControl);

        MenuCUI menuCUI = new MenuCUI(printer);
        menuCUI.setInDSSachControl(inDSSachControl);
        menuCUI.setThemSachInputCUI(themSachInputCUI);
        menuCUI.setThongKeSachControl(thongKeSachControl);
        menuCUI.setXoaSachInputCUI(xoaSachInputCUI);
        menuCUI.setTimKiemSachInputCUI(timKiemSachInputCUI);
        menuCUI.setSuaSachInputCUI(suaSachInputCUI);

        UserInputController userInputController = new UserInputController(sc, printer, menuCUI);
        userInputController.run();
    }
}
