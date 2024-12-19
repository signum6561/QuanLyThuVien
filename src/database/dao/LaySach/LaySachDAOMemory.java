package database.dao.LaySach;
import application.entity.Sach;
import database.SachDatabaseMemory;

public class LaySachDAOMemory implements LaySachDAO {
    
    public Sach laySach(String maSach) {
        return  SachDatabaseMemory.INSTANCE.selectById(maSach);   
    }
}
