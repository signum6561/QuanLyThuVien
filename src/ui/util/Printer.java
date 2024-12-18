package ui.util;

import java.io.PrintStream;

public class Printer {
    private PrintStream out;

    public Printer(PrintStream out) {
        this.out = out;
    }
    
    public Printer() {
        this.out = new PrintStream(System.out, true);
    }

    public static String colorize(String text, AnsiColors color) {
        return color.get() + text + AnsiColors.RESET.get();
    }

    public void write(String text) {
        out.print(text); out.flush();
    }

    public void write(String text, AnsiColors color) {
        out.print(colorize(text, color)); out.flush();
    }

    public void log(String text) {
        out.println(text);
    }

    public void log(String text, AnsiColors color) {
        out.println(colorize(text, color));
    }

    public void success(String text) {
        out.println(colorize("[SUCCESS] " + text, AnsiColors.GREEN));
    }

    public void error(String text) {
        out.println(colorize("[ERROR] " + text, AnsiColors.RED));
    }

    public void warning(String text) {
        out.println(colorize("[WARN] " + text, AnsiColors.YELLOW));
    }

    public void info(String text) {
        out.println(colorize("[INFO] " + text, AnsiColors.BLUE));
    }

    public void format(String format, Object ... args) {
        out.printf(format, args); out.flush();
    }
}
