package presentation.cui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import application.control.InDSSachControl;
import application.control.ThongKeSachControl;
import common.AppConstant;
import common.util.Validator;
import presentation.cui.InChiTietSach.InChiTietSachInputCUI;
import presentation.cui.SuaSach.SuaSachInputCUI;
import presentation.cui.ThemSach.ThemSachInputCUI;
import presentation.cui.TimKiemSach.TimKiemSachInputCUI;
import presentation.cui.XoaSach.XoaSachInputCUI;
import presentation.cui.util.Command;
import presentation.cui.util.CommandLine;
import presentation.cui.util.Printer;

public class MenuCUI {
    private static final String ASCII_ART_FILE = "assets/ascii-art.txt";
    private static final List<Command> SUPPORTED_COMMANDS = List.of(
        new Command("help", ".h","Hỗ trợ sử dụng"),
        new Command("thuvien", "tv", "Hiển thị các sách hiện có trong thư viện"),
        new Command("detail", "de", "Hiển thị chi tiết thông tin sách"),
        new Command("add", "Thêm sách"),
        new Command("edit", "Sửa sách"),
        new Command("delete", "Xoá sách"),
        new Command("find", "fi", "Tìm kiếm sách theo tiêu chí"),
        new Command("quit", ".q", "Thoát chương trình"),
        new Command("clear", "cls", "Clear màn hình"),
        new Command("thongke", "tk", "Thống kê sách thư viện")
    );
    private final Printer printer;
    private ThemSachInputCUI themSachInputCUI;
    private InDSSachControl inDSSachControl;
    private ThongKeSachControl thongKeSachControl;
    private TimKiemSachInputCUI timKiemSachInputCUI;
    private SuaSachInputCUI suaSachInputCUI;
    private XoaSachInputCUI xoaSachInputCUI;
    private InChiTietSachInputCUI inChiTietSachInputCUI;

    public MenuCUI(Printer printer) {
        this.printer = printer;
    }

    public void setThemSachInputCUI(ThemSachInputCUI themSachInputCUI) {
        this.themSachInputCUI = themSachInputCUI;
    }

    public void setInDSSachControl(InDSSachControl inDSSachControl) {
        this.inDSSachControl = inDSSachControl;
    }

    public void setThongKeSachControl(ThongKeSachControl thongKeSachControl) {
        this.thongKeSachControl = thongKeSachControl;
    }

    public void setXoaSachInputCUI(XoaSachInputCUI xoaSachInputCUI) {
        this.xoaSachInputCUI = xoaSachInputCUI;
    }

    public void setTimKiemSachInputCUI(TimKiemSachInputCUI timKiemSachInputCUI) {
        this.timKiemSachInputCUI = timKiemSachInputCUI;
    }

    public void setSuaSachInputCUI(SuaSachInputCUI suaSachInputCUI) {
        this.suaSachInputCUI = suaSachInputCUI;
    }

    public void setInChiTietSachInputCUI(InChiTietSachInputCUI inChiTietSachInputCUI) {
        this.inChiTietSachInputCUI = inChiTietSachInputCUI;
    }

    public void execute(CommandLine cml) {
        switch (cml.getCommand().getDefaultPrompt()) {
            case "help":
                help();
                break;
            case "add":
                themSachInputCUI.nhapThongTinSach();
                break;
            case "edit":
                if (cml.isArgQuoted()) {
                    suaSachInputCUI.timSach(cml.extractArg());
                } else {
                    suaSachInputCUI.nhapMaSach();
                }
                break;
            case "delete":
                if (cml.isArgQuoted()) {    
                    xoaSachInputCUI.xoaSach(cml.extractArg());
                } else {
                    xoaSachInputCUI.nhapMaSach();
                }
                break;
            case "find":
                if(cml.isArgQuoted()) {
                    timKiemSachInputCUI.timKiem(cml.extractArg());
                } else {
                    timKiemSachInputCUI.nhapTieuChiTiemKiem();
                }
                break;
            case "thuvien":
                inDSSachControl.execute();
                break;
            case "detail":
                if(cml.isArgQuoted()) {
                    inChiTietSachInputCUI.inChiTietSach(cml.extractArg());
                } else {
                    inChiTietSachInputCUI.nhapMaSach();
                }
                break;
            case "clear":
                printer.write("\033[H\033[2J");
                break;
            case "thongke":
                thongKeSachControl.execute();
                break;
        }
    }

    public Command getSupportedCommand(String value) {
        return SUPPORTED_COMMANDS.stream()
            .filter(c -> c.matches(value))
            .findFirst()
            .orElse(null);
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
            printer.log("Gõ \"help\" để được hỗ trợ sử dụng\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void help() {
        SUPPORTED_COMMANDS.forEach(c -> {
            String aliasPromptStr = "";
            if(!Validator.isEmptyOrNull(c.getAlias())) {
                aliasPromptStr = String.format("[%s]", c.getAlias());
            }
            String commandPromptStr = c.getDefaultPrompt() + " " + aliasPromptStr;
            printer.format("%-25s %s\n", commandPromptStr, c.getDescription());
        });
	}
}
