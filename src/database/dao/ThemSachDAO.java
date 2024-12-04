package database.dao;

import database.SachDatabaseMemory;
import entity.Sach;

public class ThemSachDAO {
    
    public void themSach(Sach sach) {
        SachDatabaseMemory.INSTANCE.insert(sach);
    }
}
