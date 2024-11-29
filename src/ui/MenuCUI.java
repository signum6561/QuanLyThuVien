package ui;

import java.io.PrintWriter;
import java.util.Scanner;

public class MenuCUI {
    private Scanner sc;
    private PrintWriter writer;
    private UIConsoleInput uiConsoleInput;
    private static final String PROMPT = "> ";

    public MenuCUI(Scanner sc, PrintWriter writer, UIConsoleInput uiConsoleInput) {
        this.sc = sc;
        this.writer = writer;
        this.uiConsoleInput = uiConsoleInput;
    }

    public void run() {
        help();
        while (true) {
            writer.print(PROMPT); writer.flush();
            String command = sc.nextLine().trim();
            if(command.equalsIgnoreCase("help")) {
                help();
                continue;
            }
            if(command.equalsIgnoreCase("thuvien") || command.equalsIgnoreCase("tv")) {
                uiConsoleInput.xemDanhSach();
                continue;
            }
            if(command.equalsIgnoreCase("detail") || command.equalsIgnoreCase("de")) {
                uiConsoleInput.xemThongTinSach();
                continue;
            }
            if(command.equalsIgnoreCase("add")) {
                uiConsoleInput.themSach();
                continue;
            }
            if(command.equalsIgnoreCase("update")) {
                uiConsoleInput.suaSach();
                continue;
            }
            if(command.equalsIgnoreCase("delete")) {
                uiConsoleInput.xoaSach();
                continue;
            }
            if(command.equalsIgnoreCase("find")) {
                uiConsoleInput.timKiemSach();
                continue;
            }
            if(command.equalsIgnoreCase("clear") || command.equalsIgnoreCase("cls")) {
                writer.print("\033[H\033[2J");
                continue;
            }
            if(command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("!q")) {
                break;
            }
        }
    }

    private void help() {
        writer.println("~~~~~~Console Help~~~~~~");
		writer.println("[help] Ho tro su dung");
        writer.println("[thuvien][tv] In danh sach tat ca cac sach trong thu vien");
        writer.println("[detail][de] In thong tin chi tiet sach voi ma sach");
        writer.println("[add] Them sach");
        writer.println("[update] Sua sach");
        writer.println("[delete] Xoa sach");
        writer.println("[find] Tim kiem sach");
        writer.println("[quit][!q] Thoat chuong trinh");
        writer.println("[clear][cls] Clear man hinh");
	}
}
