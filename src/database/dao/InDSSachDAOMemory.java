package database.dao;

import java.util.List;

import control.InDSSachDAO;
import database.SachDatabaseMemory;
import entity.Sach;

public class InDSSachDAOMemory implements InDSSachDAO {

    @Override
    public List<Sach> layDSSach() {
        return SachDatabaseMemory.INSTANCE.selectAll();
    }
}
