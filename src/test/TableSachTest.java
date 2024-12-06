package test;

import database.SachDatabaseMemory;
import ui.util.Printer;
import ui.util.TableSach;

public class TableSachTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        TableSach tableSach = new TableSach(SachDatabaseMemory.INSTANCE.selectAll(), printer);
        tableSach.show();
    }
}
