package database.dao;

import java.util.List;

import control.InDSSachDAO;
import database.SachDatabaseFile;
import entity.Sach;

public class InDSSachDAOFile implements InDSSachDAO {
    private SachDatabaseFile dbFile;

    public InDSSachDAOFile(SachDatabaseFile dbFile) {
        this.dbFile = dbFile;
    }
    
    @Override
    public List<Sach> layDSSach() {
        return dbFile.readAll();
    }
}
