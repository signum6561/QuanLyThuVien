package database.dao;
import database.SachDatabaseMemory;
import entity.Sach;
public class SuaSachDAOMemory {
    public void suaSach(Sach sach) {
        SachDatabaseMemory.INSTANCE.update(sach);
    }
}
