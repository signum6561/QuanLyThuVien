package database.dao;
import database.SachDatabaseMemory;
import entity.Sach;

public class LaySachDAO {
    
    public Sach laySach(String maSach) {
        return  SachDatabaseMemory.INSTANCE.selectById(maSach);
        
    }

}
