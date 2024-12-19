package presentation.cui.SuaSach;
import presentation.util.Printer;
public class SuaSachOutputCUI {
    public Printer printer;
    public SuaSachOutputCUI(Printer printer) {
        this.printer = printer;
    }
    public void thongBaoSua(String message) {
        printer.success(message + "\n");
    }
}
