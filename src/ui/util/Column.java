package ui.util;

public class Column {
    private String header;
    private int width;
    private Align align;

    public static enum Align {
        LEFT, RIGHT, CENTER
    }

    public Column(String header) {
        this(header, Align.LEFT);
    }

    public Column(String header, Align align) {
        this.header = header;
        this.align = align;
        this.width = header.length();
    }

    public Align getAlign() {
        return this.align;
    }

    public void setAlign(Align align) {
        this.align = align;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        if(width < header.length()) {
            this.width = header.length();
        } else {
            this.width = width;
        }
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return header;
    }
}
