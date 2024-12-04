package ui.util;

import java.io.PrintWriter;

public class Printer {
    private PrintWriter writer;
    private static final String RESET = "\033[0m";

    public Printer() {
        this.writer = new PrintWriter(System.out, true);
    }

    private String colorize(String text, AnsiColors color) {
        return color.get() + text + RESET;
    }

    public void write(String text) {
        writer.print(text); writer.flush();
    }

    public void log(String text) {
        writer.println(text);
    }

    public void success(String text) {
        writer.println(colorize(text, AnsiColors.GREEN));
    }

    public void error(String text) {
        writer.println(colorize(text, AnsiColors.RED));
    }

    public void warning(String text) {
        writer.println(colorize(text, AnsiColors.YELLOW));
    }

    public void info(String text) {
        writer.println(colorize(text, AnsiColors.BLUE));
    }

    public void format(String format, Object ... args) {
        writer.printf(format, args); writer.flush();
    }
}
