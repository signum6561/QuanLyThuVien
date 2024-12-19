package application.control;

import application.entity.Sach;
import database.dao.LaySach.LaySachDAO;

public class LaySachControl {
    private final LaySachDAO laySachDao;
    private Sach result;

    public LaySachControl(LaySachDAO laySachDAO) {
        this.laySachDao = laySachDAO;
    }

    public void execute(String maSach) {
        this.result = laySachDao.laySach(maSach);
    }

    public Sach getResult() {
        return this.result;
    }
}
