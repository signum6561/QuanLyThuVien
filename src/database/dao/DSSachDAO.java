package database.dao;

import java.util.List;

import database.SachDatabaseMemory;
import entity.Sach;

public class DSSachDAO {

    public List<Sach> layDSSach() {
        return SachDatabaseMemory.INSTANCE.selectAll();
    }
}
