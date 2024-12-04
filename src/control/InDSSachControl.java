package control;

import database.dao.DSSachDAO;
import ui.InDSSach.InDSSachOutputCUI;

public class InDSSachControl {
    private InDSSachOutputCUI inDSSachOutput;
    private DSSachDAO dsSachDAO;

    public InDSSachControl(InDSSachOutputCUI inDSSachOutput, DSSachDAO dsSachDAO) {
        this.inDSSachOutput = inDSSachOutput;
        this.dsSachDAO = dsSachDAO;
    }
    
    public void execute() {
        inDSSachOutput.inDanhSach(dsSachDAO.layDSSach());
    }
}
