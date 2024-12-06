package ui;

import java.io.File;
import java.util.Scanner;

import common.AppConstant;
import ui.ThemSach.ThemSachInputCUI;
import ui.util.AnsiColors;
import ui.util.Command;
import ui.util.Printer;
import util.Validator;

public class MenuCUI {
    private Scanner sc;
    private Printer printer;
    private final String PROMPT = "app$ ";
    private final String ASCII_ART_FILE = "assets/ascii-art.txt";
    private static final Command[] COMMANDS = new Command[] {
        new Command("help", ".h","Ho tro su dung"),
        new Command("thuvien", "tv", "In danh sach tat ca cac sach trong thu vien"),
        new Command("detail", "de", "In thong tin chi tiet sach voi ma sach"),
        new Command("add", "Them sach"),
        new Command("update", "Sua sach"),
        new Command("delete", "Xoa sach"),
        new Command("find", "fi", "Tim kiem sach"),
        new Command("quit", ".q", "Thoat chuong trinh"),
        new Command("clear", "cls", "Clear man hinh")
    };

    // Dependencies
    private ThemSachInputCUI themSachInputCUI;

    public MenuCUI(Scanner sc, Printer printer) {
        this.sc = sc;
        this.printer = printer;
    }

    public void setThemSachInputCUI(ThemSachInputCUI themSachInputCUI) {
        this.themSachInputCUI = themSachInputCUI;
    }

    public void run() {
        welcome();
        while (true) {
            printer.write(PROMPT);
            String inputTxt = sc.nextLine().trim();
            if(inputTxt.isEmpty()) {
                continue;
            }
            Command command = getCommand(inputTxt.toLowerCase());
            if(command == null) {
                printer.error(AppConstant.ERROR_UNKNOWN_COMMAND(inputTxt));
                continue;
            }
            switch (command.getDefaultPrompt()) {
                case "help":
                    help();
                    continue;
                case "add":
                    themSachInputCUI.nhapThongTinSach();
                    continue;
                case "update":
                    continue;
                case "delete":
                    continue;
                case "find":
                    continue;
                case "thuvien":
                    continue;
                case "detail":
                    continue;
                case "clear":
                    printer.write("\033[H\033[2J");
                    continue;
                case "quit":
                    break;
                default:
                    continue;
            }
        }
    }

    private Command getCommand(String value) {
        for (Command c : COMMANDS) {
            if (c.matches(value)) {
                return c;
            }
        }
        return null;
    }

    private void welcome() {
        try {
            File file = new File(getClass().getResource(ASCII_ART_FILE).getPath());
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                printer.log(sc.nextLine(), AnsiColors.CYAN_BOLD_BRIGHT);
            }
            sc.close();
            printer.log("Welcome to " + AppConstant.APP_NAME + " v" + AppConstant.APP_VERSION);
            printer.log("Go \"help\" de duoc ho tro su dung");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void help() {
        for (Command c : COMMANDS) {
            String aliasPromptStr = "";
            if(!Validator.isEmptyOrNull(c.getAlias())) {
                aliasPromptStr = String.format("[%s]", c.getAlias());
            }
            String commandPromptStr = c.getDefaultPrompt() + " " + aliasPromptStr;
            printer.format("%-25s %s\n", commandPromptStr, c.getDescription());
        }
	}
}
