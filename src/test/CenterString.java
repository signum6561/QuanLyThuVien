package test;

public class CenterString {
    public static void main(String[] args) {
        String str = "Hello";
        int width = 20;

        // Calculate the padding on each side
        int padding = (width - str.length()) / 2;

        // Create a StringBuilder to construct the centered string
        StringBuilder centeredString = new StringBuilder();
        centeredString.append("|");
        centeredString.append(" ".repeat(padding));
        centeredString.append(str);
        centeredString.append(" ".repeat(width - padding - str.length()));
        centeredString.append("|");

        // Print the centered string
        System.out.println(centeredString);
    }
}
