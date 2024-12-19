package database.dao.InDSSach;

import java.util.List;

import application.entity.Sach;
import database.SachDatabaseMemory;

public class InDSSachDAOMemory implements InDSSachDAO {

    @Override
    public List<Sach> layDSSach() {
        return SachDatabaseMemory.INSTANCE.selectAll();
    }
}
