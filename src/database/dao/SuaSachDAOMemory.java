package database.dao;

import control.SuaSachDAO;
import database.SachDatabaseMemory;
import entity.Sach;

public class SuaSachDAOMemory implements SuaSachDAO {

    @Override
    public void suaSach(Sach sach) {
        SachDatabaseMemory.INSTANCE.update(sach);
    }
}
