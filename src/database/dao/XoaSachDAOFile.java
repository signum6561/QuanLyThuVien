package database.dao;

import java.util.List;

import control.XoaSachDAO;
import database.SachDatabaseFile;
import entity.Sach;

public class XoaSachDAOFile implements XoaSachDAO {
    private final SachDatabaseFile dbFile;

    public XoaSachDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }

    @Override
    public void xoaSach(Sach sach) {
        String maSach = sach.getMaSach();
        List<Sach> sachList = dbFile.readAll();
        sachList.removeIf(s -> s.getMaSach().equals(maSach));
        dbFile.writeAll(sachList);
    }
}
