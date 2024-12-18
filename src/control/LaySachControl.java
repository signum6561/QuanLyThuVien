package control;
import database.dao.LaySachDAO;
import entity.Sach;
public class LaySachControl {
    private final LaySachDAO laySachDAO;
    private Sach sach;

    public LaySachControl(LaySachDAO laySachDAO) {
        this.laySachDAO = laySachDAO;
    }
    

    public void execute(String maSach){
        this.sach =laySachDAO.laySach(maSach);
        return;
    }
    public Sach getSach(){
        return sach;
    }
}
