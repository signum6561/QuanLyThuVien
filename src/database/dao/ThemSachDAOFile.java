package database.dao;

import java.util.List;

import control.ThemSachDAO;
import database.SachDatabaseFile;
import entity.Sach;

public class ThemSachDAOFile implements ThemSachDAO {
    private SachDatabaseFile dbFile;

    public ThemSachDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }

    @Override
    public void themSach(Sach sach) {
        List<Sach> sachList = dbFile.readAll();
        sachList.add(sach);
        dbFile.writeAll(sachList);
    }
}
