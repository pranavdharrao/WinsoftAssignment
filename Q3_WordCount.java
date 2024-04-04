// Q3:Write a Java Program to count the number of words in a string using HashMap.

import java.util.HashMap;

public class Q3_WordCount {
    public static void main(String[] args) {
        String str = "This is a sample string to demonstrate word count in Java using HashMap";
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        String[] words = str.split(" ");

        // Count the frequency of each word
        for (String word : words) {
            String lowercaseWord = word.toLowerCase();
            wordCountMap.put(lowercaseWord, wordCountMap.getOrDefault(lowercaseWord, 0) + 1);
        }

        // Display word count
        System.out.println("Word count in the string:");
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }
    }
}
