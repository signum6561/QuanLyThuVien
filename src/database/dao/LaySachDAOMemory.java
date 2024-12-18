package database.dao;
import control.LaySachDAO;
import database.SachDatabaseMemory;
import entity.Sach;

public class LaySachDAOMemory implements LaySachDAO {
    
    public Sach laySach(String maSach) {
        return  SachDatabaseMemory.INSTANCE.selectById(maSach);   
    }
}
