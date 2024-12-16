package ui;

import java.util.Scanner;

import common.AppConstant;
import ui.util.AnsiColors;
import ui.util.Command;
import ui.util.Printer;

public class UserInputController {
    private static final String PROMPT = "qls> ";

    private final Scanner sc;
    private final Printer printer;
    private final MenuCUI menuCUI;

    public UserInputController(Scanner sc, Printer printer, MenuCUI menuCUI) {
        this.sc = sc;
        this.printer = printer;
        this.menuCUI = menuCUI;
    }

    public void run() {
        menuCUI.welcome();
        while (true) {
            printer.write(PROMPT, AnsiColors.YELLOW_BOLD_BRIGHT);
            String inputLine = sc.nextLine().trim();
            if(inputLine.isEmpty()) {
                continue;
            }

            Command command = menuCUI.getCommand(inputLine);
            if(command == null) {
                printer.error(AppConstant.ERROR_UNKNOWN_COMMAND(inputLine));
                continue;
            }

            switch (command.getDefaultPrompt()) {
                case "quit":
                    break;
                default:
                    menuCUI.execute(command);
                    continue;
            }
        }
    }
}
