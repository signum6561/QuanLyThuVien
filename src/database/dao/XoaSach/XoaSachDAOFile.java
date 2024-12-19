package database.dao.XoaSach;

import java.util.List;

import application.entity.Sach;
import database.SachDatabaseFile;

public class XoaSachDAOFile implements XoaSachDAO {
    private final SachDatabaseFile dbFile;

    public XoaSachDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }

    @Override
    public void xoaSach(String maSach) {
        List<Sach> sachList = dbFile.readAll();
        sachList.removeIf(s -> s.getMaSach().equals(maSach));
        dbFile.writeAll(sachList);
    }
}
