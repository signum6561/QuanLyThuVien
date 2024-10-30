package util;

import java.util.Random;

public class IdGenerator {
    private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final static int DEFAULT_LENGTH = 5;
    private final static String PREFIX = "B";

    private String generateFromPattern(String pattern) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            int index = random.nextInt(pattern.length());
                char randomChar = pattern.charAt(index);
                sb.append(randomChar);
        }
        return sb.toString();
    }

    public String generate() {
        String randomString1 = generateFromPattern(ALPHABET);
        String randomString2 = generateFromPattern(ALPHABET);
        
        return String.join("-", PREFIX, randomString1, randomString2);
    }

}
