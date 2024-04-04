// Q4:Write a Java Program to find the duplicate characters in a string.

import java.util.HashMap;

public class Q4_DuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";

        HashMap<Character, Integer> charCountMap = new HashMap<>();

        char[] charArray = str.toCharArray();

        for (char ch : charArray) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Duplicate characters in the string '" + str + "' :");
        for (char ch : charCountMap.keySet()) {
            if (charCountMap.get(ch) > 1) {
                System.out.println(ch + ": " + charCountMap.get(ch));
            }
        }
    }
}
