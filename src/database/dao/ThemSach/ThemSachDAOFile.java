package database.dao.ThemSach;

import java.util.List;

import application.entity.Sach;
import database.SachDatabaseFile;

public class ThemSachDAOFile implements ThemSachDAO {
    private final SachDatabaseFile dbFile;

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
