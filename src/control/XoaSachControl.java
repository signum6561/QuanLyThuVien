package control;

import entity.Sach;
import ui.XoaSach.XoaSachOutputCUI;

public class XoaSachControl {
    private final XoaSachDAO xoaSachDao;
    private final LaySachControl laySachControl;
    private final XoaSachOutputCUI xoaSachOutput;

    public XoaSachControl(XoaSachDAO xoaSachDao, LaySachControl laySachControl, XoaSachOutputCUI xoaSachOutput) {
        this.xoaSachDao = xoaSachDao;
        this.laySachControl = laySachControl;
        this.xoaSachOutput = xoaSachOutput;
    }

    public void execute(String maSach) {
        laySachControl.execute(maSach);
        Sach sach = laySachControl.getResult();
        if(sach == null) {
            xoaSachOutput.khongTimThaySach(maSach);
            return;
        }   
        xoaSachDao.xoaSach(sach);
        xoaSachOutput.thongBaoThanhCong();
    }
}
