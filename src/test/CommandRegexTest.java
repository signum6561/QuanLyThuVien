package test;

import java.util.regex.Pattern;

public class CommandRegexTest {
    public static void main(String[] args) {
        String input = "detail -id 123456789";  

        String[] parts = Pattern.compile("\\s+(?=\\w+)").split(input);
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
