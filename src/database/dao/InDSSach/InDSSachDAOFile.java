package database.dao.InDSSach;

import java.util.List;

import application.entity.Sach;
import database.SachDatabaseFile;

public class InDSSachDAOFile implements InDSSachDAO {
    private final SachDatabaseFile dbFile;

    public InDSSachDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }
    
    @Override
    public List<Sach> layDSSach() {
        return dbFile.readAll();
    }
}
