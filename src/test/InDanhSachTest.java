package test;

import control.InDSSachControl;
import database.dao.DSSachDAO;
import ui.InDSSach.InDSSachOutputCUI;
import ui.util.Printer;

public class InDanhSachTest {

	public static void main(String[] args) {
		 Printer printer = new Printer();
		 InDSSachOutputCUI inDSSachOutput = new InDSSachOutputCUI(printer);
		 DSSachDAO dsSachDAO = new DSSachDAO();
		 InDSSachControl inDSSachControl = new InDSSachControl(inDSSachOutput, dsSachDAO);
		 inDSSachControl.execute();
		
	}

}
