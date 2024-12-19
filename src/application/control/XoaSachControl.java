package application.control;

import database.dao.XoaSach.XoaSachDAO;
import presentation.cui.XoaSach.XoaSachOutputCUI;

public class XoaSachControl {
    private final XoaSachDAO xoaSachDao;
    private final TimMaSachControl timMaSachControl;
    private final XoaSachOutputCUI xoaSachOutput;

    public XoaSachControl(XoaSachDAO xoaSachDao, TimMaSachControl timMaSachControl, XoaSachOutputCUI xoaSachOutput) {
        this.xoaSachDao = xoaSachDao;
        this.timMaSachControl = timMaSachControl;
        this.xoaSachOutput = xoaSachOutput;
    }

    public void execute(String maSach) {
        timMaSachControl.execute(maSach);
        if(!timMaSachControl.isMaSachExist()) {
            return;
        }
        xoaSachDao.xoaSach(maSach);
        xoaSachOutput.thongBaoThanhCong();
    }
}
