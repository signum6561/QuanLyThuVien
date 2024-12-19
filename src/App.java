import java.util.Scanner;

import application.control.InChiTietSachControl;
import application.control.InDSSachControl;
import application.control.LayDSLoaiSachChiTietControl;
import application.control.LaySachControl;
import application.control.SuaSachControl;
import application.control.ThemSachControl;
import application.control.ThongKeSachControl;
import application.control.TimKiemSachControl;
import application.control.TimMaSachControl;
import application.control.XoaSachControl;
import common.IdGenerator;
import database.SachDatabaseFile;
import database.dao.InDSSach.InDSSachDAO;
import database.dao.InDSSach.InDSSachDAOFile;
import database.dao.LayDSLoaiSachChiTiet.LayDSLoaiSachChiTietDAO;
import database.dao.LayDSLoaiSachChiTiet.LayDSLoaiSachChiTietDAOFile;
import database.dao.LaySach.LaySachDAO;
import database.dao.LaySach.LaySachDAOFile;
import database.dao.SuaSach.SuaSachDAO;
import database.dao.SuaSach.SuaSachDAOFile;
import database.dao.ThemSach.ThemSachDAO;
import database.dao.ThemSach.ThemSachDAOFile;
import database.dao.TimKiemSach.TimKiemSachDAO;
import database.dao.TimKiemSach.TimKiemSachDAOFile;
import database.dao.XoaSach.XoaSachDAO;
import database.dao.XoaSach.XoaSachDAOFile;
import presentation.cui.MenuCUI;
import presentation.cui.UserInputController;
import presentation.cui.InChiTietSach.InChiTietSachInputCUI;
import presentation.cui.InChiTietSach.InChiTietSachOutputCUI;
import presentation.cui.InDSSach.InDSSachOutputCUI;
import presentation.cui.SuaSach.SuaSachInputCUI;
import presentation.cui.SuaSach.SuaSachOutputCUI;
import presentation.cui.ThemSach.ThemSachInputCUI;
import presentation.cui.ThemSach.ThemSachOutputCUI;
import presentation.cui.ThongKeSach.ThongKeSachOutputCUI;
import presentation.cui.TimKiemSach.TimKiemSachInputCUI;
import presentation.cui.TimKiemSach.TimKiemSachOutputCUI;
import presentation.cui.TimMaSach.TimMaSachOutputCUI;
import presentation.cui.XoaSach.XoaSachInputCUI;
import presentation.cui.XoaSach.XoaSachOutputCUI;
import presentation.util.Printer;

public class App {
    public static void main(String[] args) throws Exception {
        Printer printer = new Printer();
        Scanner sc = new Scanner(System.in);
        SachDatabaseFile dbFile = new SachDatabaseFile("sach.db");

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

        InChiTietSachOutputCUI inChiTietSachOutputCUI = new InChiTietSachOutputCUI(printer);
        InChiTietSachControl inChiTietSachControl = new InChiTietSachControl(timMaSachControl, inChiTietSachOutputCUI);
        InChiTietSachInputCUI inChiTietSachInputCUI = new InChiTietSachInputCUI(printer, sc, inChiTietSachControl);

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
        menuCUI.setInChiTietSachInputCUI(inChiTietSachInputCUI);

        UserInputController userInputController = new UserInputController(sc, printer, menuCUI);
        userInputController.run();
    }
}
