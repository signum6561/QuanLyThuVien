package database.dao.ThemSach;

import application.entity.Sach;
import database.SachDatabaseMemory;

public class ThemSachDAOMemory implements ThemSachDAO {
    
    @Override
    public void themSach(Sach sach) {
        SachDatabaseMemory.INSTANCE.insert(sach);
    }
}
