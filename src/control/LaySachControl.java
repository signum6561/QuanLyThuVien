package control;

import entity.Sach;

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
