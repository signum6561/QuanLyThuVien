package presentation.cui;

import java.util.Scanner;

import common.AppConstant;
import presentation.cui.util.AnsiColors;
import presentation.cui.util.Command;
import presentation.cui.util.CommandLine;
import presentation.cui.util.Printer;

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

            String commandPrompt = inputLine.split(" ")[0];

            Command command = menuCUI.getSupportedCommand(commandPrompt);
            if(command == null) {
                printer.error(AppConstant.ERROR_UNKNOWN_COMMAND(inputLine));
                continue;
            }

            String rawArgs = inputLine.substring(commandPrompt.length()).trim();

            if(command.getDefaultPrompt().equals("quit")) {
                break;
            }
            CommandLine commandLine = new CommandLine(command, inputLine, rawArgs);
            menuCUI.execute(commandLine);
        }
    }
}
