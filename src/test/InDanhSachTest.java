package test;

import control.InDSSachControl;
import control.InDSSachDAO;
import database.dao.InDSSachDAOMemory;
import ui.InDSSach.InDSSachOutputCUI;
import ui.util.Printer;

public class InDanhSachTest {

	public static void main(String[] args) {
		Printer printer = new Printer();
		InDSSachOutputCUI inDSSachOutput = new InDSSachOutputCUI(printer);
		InDSSachDAO inDSSachDAO = new InDSSachDAOMemory();
		InDSSachControl inDSSachControl = new InDSSachControl(inDSSachOutput, inDSSachDAO);
		inDSSachControl.execute();
	}
}
