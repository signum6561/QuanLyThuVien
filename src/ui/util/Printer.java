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

    public void write(String message) {
        writer.print(message); writer.flush();
    }

    public void log(String message) {
        writer.println(message);
    }

    public void success(String message) {
        writer.println(colorize(message, AnsiColors.GREEN));
    }

    public void error(String message) {
        writer.println(colorize(message, AnsiColors.RED));
    }

    public void warning(String message) {
        writer.println(colorize(message, AnsiColors.YELLOW));
    }

    public void info(String message) {
        writer.println(colorize(message, AnsiColors.BLUE));
    }

    public void format(String format, Object ... args) {
        writer.printf(format, args); writer.flush();
    }
}
