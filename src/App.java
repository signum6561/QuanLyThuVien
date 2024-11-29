import java.io.PrintWriter;
import java.util.Scanner;

import control.QuanLySachControl;
import database.SachDatabaseMemory;
import ui.MenuCUI;
import ui.UIConsoleInput;
import ui.UIConsoleOutput;
import util.IdGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        Scanner sc = new Scanner(System.in);
        
        UIConsoleOutput uiOutput = new UIConsoleOutput(printWriter);
        IdGenerator idGenerator = new IdGenerator();
        SachDatabaseMemory databaseMemory = new SachDatabaseMemory();

        QuanLySachControl quanLySachControl = new QuanLySachControl(uiOutput, databaseMemory, idGenerator);
        UIConsoleInput uiInput = new UIConsoleInput(sc, printWriter, quanLySachControl);
        MenuCUI menuConsoleController = new MenuCUI(sc, printWriter, uiInput);

        menuConsoleController.run();
        printWriter.close();
    }
}
