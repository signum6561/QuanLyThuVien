package database.dao;

import control.ThemSachDAO;
import database.SachDatabaseMemory;
import entity.Sach;

public class ThemSachDAOMemory implements ThemSachDAO {
    
    @Override
    public void themSach(Sach sach) {
        SachDatabaseMemory.INSTANCE.insert(sach);
    }
}
