package control;

import ui.InDSSach.InDSSachOutputCUI;

public class InDSSachControl {
    private InDSSachOutputCUI inDSSachOutput;
    private InDSSachDAO inDsSachDb;

    public InDSSachControl(InDSSachOutputCUI inDSSachOutput, InDSSachDAO inDSSachDao) {
        this.inDSSachOutput = inDSSachOutput;
        this.inDsSachDb = inDSSachDao;
    }
    
    public void execute() {
        inDSSachOutput.inDanhSach(inDsSachDb.layDSSach());
    }
}
