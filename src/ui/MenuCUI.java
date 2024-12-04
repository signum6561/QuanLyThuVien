package ui;

import java.io.PrintWriter;
import java.util.Scanner;

public class MenuCUI {
    private Scanner sc;
    private PrintWriter writer;
    private static final String PROMPT = "> ";

    public MenuCUI(Scanner sc, PrintWriter writer) {
        this.sc = sc;
        this.writer = writer;
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
