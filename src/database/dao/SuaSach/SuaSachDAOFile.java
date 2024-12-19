package database.dao.SuaSach;

import java.util.List;

import application.entity.Sach;
import database.SachDatabaseFile;

public class SuaSachDAOFile implements SuaSachDAO {
    private final SachDatabaseFile dbFile;

    public SuaSachDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }

    @Override
    public void suaSach(Sach sach) {
        List<Sach> sachList = dbFile.readAll();
        String maSach = sach.getMaSach();
        for (int i = 0; i < sachList.size(); i++) {
            Sach item = sachList.get(i);
            if (item.getMaSach().equalsIgnoreCase(maSach)) {
                sachList.set(i, sach);
                break;
            }
        }
        dbFile.writeAll(sachList);
    }

}
