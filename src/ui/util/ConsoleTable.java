package ui.util;

import java.util.List;

public abstract class ConsoleTable<T> {
    protected final Printer printer;
    protected List<T> items;
    protected static final String TABLE_POINT = "+";
    protected static final String TABLE_LINE_HORIZONTAL = "-";
    protected static final String TABLE_LINE_VERTICAL = "|";
    protected enum Align {
        LEFT,
        CENTER,
        RIGHT,
    }
    private static final String INDEX_HEADER = "#";
    private boolean indexEnabled;
    private int maxIndexWidth;

    public ConsoleTable(Printer printer) {
        this(null, printer);
    }

    public ConsoleTable(List<T> items, Printer printer) {
        this.items = items;
        this.printer = printer;
        init();
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setIndexEnabled(boolean b) {
        indexEnabled = b;
    }

    public boolean isIndexEnabled() {
        return indexEnabled;
    }

    protected String getLine(int length) {
        length += 2;
        StringBuilder line = new StringBuilder();
        return line
            .append(TABLE_POINT)
            .append(TABLE_LINE_HORIZONTAL.repeat(length))
            .toString();
    }

    protected String getCell(String value,int maxWidth, Align align) {
        StringBuilder cell = new StringBuilder();
        cell.append(TABLE_LINE_VERTICAL);
        cell.append(" ");
        if (value.length() >= maxWidth) {
            align = Align.LEFT;
        }
        switch (align) {
            case LEFT:
                String leftFormat = "%-" + maxWidth + "s";
                cell.append(String.format(leftFormat, value));
                break;
            case CENTER:
                int leftPadding = (maxWidth - value.length()) / 2;
                int rightPadding = maxWidth - leftPadding;
                String centerFormat = " ".repeat(leftPadding) + "%-" + rightPadding + "s";
                cell.append(String.format(centerFormat, value));
                break;
            case RIGHT:
                String rightFormat = "%" + maxWidth + "s";
                cell.append(String.format(rightFormat, value));
                break;
        }
        cell.append(" ");
        return cell.toString();
    }

    protected String getCell(String value, int maxWidth) {
        return getCell(value, maxWidth, Align.LEFT);
    }

    protected void printDivider() {
        StringBuilder divider;
        if (indexEnabled) {
            divider = new StringBuilder()
                .append(getLine(maxIndexWidth))
                .append(getDivider());
        } else {
            divider = getDivider();
        }
        divider.append(TABLE_POINT);
        printer.log(divider.toString());
    }

    protected void printRow(StringBuilder row) {
        row.append(TABLE_LINE_VERTICAL);
        printer.log(row.toString());
    };

    private void printBody() {
        for (int i = 0; i < items.size(); i++) {
            StringBuilder row;
            T t = items.get(i);
            if (indexEnabled) {
                row = new StringBuilder()
                    .append(getCell(String.valueOf(i + 1), maxIndexWidth, Align.CENTER))
                    .append(getRowData(t));
            } else {
                row = getRowData(t);
            }
            printRow(row);
        };
    }

    private void printHeader() {
        StringBuilder headers;
        if (indexEnabled) {
            headers = new StringBuilder()
                .append(getCell(INDEX_HEADER, maxIndexWidth, Align.CENTER))
                .append(getHeaders());
        } else {
            headers = getHeaders();
        }
        printRow(headers);
    }

    protected abstract void init();

    public void show() {
        maxIndexWidth = String.valueOf(items.size()).length();
        adjustWidths();
        printDivider();
        printHeader();
        printDivider();
        printBody();
        printDivider();
    }

    protected abstract StringBuilder getDivider();

    protected abstract StringBuilder getRowData(T item);

    protected abstract StringBuilder getHeaders();

    protected abstract void adjustWidths();
}
