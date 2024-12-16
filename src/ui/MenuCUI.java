package ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import common.AppConstant;
import ui.ThemSach.ThemSachInputCUI;
import ui.util.Command;
import ui.util.Printer;
import util.Validator;

public class MenuCUI {
    private static final String ASCII_ART_FILE = "assets/ascii-art.txt";
    private static final Command[] COMMANDS = new Command[] {
        new Command("help", ".h","Ho tro su dung"),
        new Command("thuvien", "tv", "In danh sach tat ca cac sach trong thu vien"),
        new Command("detail", "de", "In thong tin chi tiet sach voi ma sach"),
        new Command("add", "Them sach"),
        new Command("edit", "Sua sach"),
        new Command("delete", "Xoa sach"),
        new Command("find", "fi", "Tim kiem sach"),
        new Command("quit", ".q", "Thoat chuong trinh"),
        new Command("clear", "cls", "Clear man hinh")
    };

    private final Printer printer;
    private ThemSachInputCUI themSachInputCUI;

    public MenuCUI(Printer printer) {
        this.printer = printer;
    }

    public void setThemSachInputCUI(ThemSachInputCUI themSachInputCUI) {
        this.themSachInputCUI = themSachInputCUI;
    }

    public void execute(Command command, String ...args) {
        switch (command.getDefaultPrompt()) {
            case "help":
                help();
                break;
            case "add":
                themSachInputCUI.nhapThongTinSach();
                break;
            case "update":
                break;
            case "delete":
                break;
            case "find":
                break;
            case "thuvien":
                break;
            case "detail":
                break;
            case "clear":
                printer.write("\033[H\033[2J");
                break;
        }
    }

    public Command getCommand(String value) {
        for (Command c : COMMANDS) {
            if (c.matches(value)) {
                return c;
            }
        }
        return null;
    }

    public void welcome() {
        try {
            InputStream inputStream = getClass().getResourceAsStream(ASCII_ART_FILE);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                printer.log(line);
            }
            br.close();
            printer.log("Welcome to " + AppConstant.APP_NAME + " v" + AppConstant.APP_VERSION);
            printer.log("Go \"help\" de duoc ho tro su dung\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void help() {
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
