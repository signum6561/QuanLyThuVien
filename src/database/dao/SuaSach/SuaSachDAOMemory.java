package database.dao.SuaSach;

import application.entity.Sach;
import database.SachDatabaseMemory;

public class SuaSachDAOMemory implements SuaSachDAO {

    @Override
    public void suaSach(Sach sach) {
        SachDatabaseMemory.INSTANCE.update(sach);
    }
}
