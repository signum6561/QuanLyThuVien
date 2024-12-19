package database.dao.LaySach;

import java.util.List;

import application.entity.Sach;
import database.SachDatabaseFile;

public class LaySachDAOFile implements LaySachDAO {
    private final SachDatabaseFile dbFile;

    public LaySachDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }

    @Override
    public Sach laySach(String maSach) {
        List<Sach> sachList = dbFile.readAll();
        return sachList.stream()
                .filter(sach -> sach.getMaSach().equals(maSach))
                .findFirst()
                .orElse(null);
    }
}
