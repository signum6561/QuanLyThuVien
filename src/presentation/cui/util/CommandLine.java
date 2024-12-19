package presentation.cui.util;

public class CommandLine {
    private Command command;
    private String rawLine;
    private String arg;

    public CommandLine(Command command, String rawLine, String arg) {
        this.command = command;
        this.rawLine = rawLine;
        this.arg = arg;
    }

    public boolean isArgQuoted() {
        return arg.startsWith("\"") && arg.endsWith("\"");
    }

    public String extractArg() {
        return arg.substring(1, arg.length() - 1);
    }

    public Command getCommand() {
        return this.command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public String getArg() {
        return this.arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public String getRawLine() {
        return this.rawLine;
    }

    public void setRawLine(String rawLine) {
        this.rawLine = rawLine;
    }

}
