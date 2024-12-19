package application.control;

import presentation.cui.InChiTietSach.InChiTietSachOutputCUI;

public class InChiTietSachControl {
    private final TimMaSachControl timMaSachControl;
    private final InChiTietSachOutputCUI inChiTietSachOutput;

    public InChiTietSachControl(TimMaSachControl timMaSachControl, InChiTietSachOutputCUI inChiTietSachOutput) {
        this.timMaSachControl = timMaSachControl;
        this.inChiTietSachOutput = inChiTietSachOutput;
    }

    public void execute(String maSach) {
        timMaSachControl.execute(maSach);
        if(!timMaSachControl.isMaSachExist()) {
            return;
        }
        inChiTietSachOutput.inChiTietSach(timMaSachControl.getResult());
    }
}
