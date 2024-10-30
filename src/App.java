import java.io.PrintWriter;

import ui.UIConsoleOutput;

public class App {
    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter(System.out);
        UIConsoleOutput uiOutput = new UIConsoleOutput(writer);
    }
}
