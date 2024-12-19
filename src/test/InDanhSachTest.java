package test;

import application.control.InDSSachControl;
import database.dao.InDSSach.InDSSachDAO;
import database.dao.InDSSach.InDSSachDAOMemory;
import presentation.cui.InDSSach.InDSSachOutputCUI;
import presentation.util.Printer;

public class InDanhSachTest {

	public static void main(String[] args) {
		Printer printer = new Printer();
		InDSSachOutputCUI inDSSachOutput = new InDSSachOutputCUI(printer);
		InDSSachDAO inDSSachDAO = new InDSSachDAOMemory();
		InDSSachControl inDSSachControl = new InDSSachControl(inDSSachOutput, inDSSachDAO);
		inDSSachControl.execute();
	}
}
