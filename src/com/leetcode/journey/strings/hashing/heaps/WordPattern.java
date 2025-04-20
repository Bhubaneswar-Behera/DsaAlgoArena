package com.leetcode.journey.strings.hashing.heaps;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s)); // Output: true
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check if the mappings are consistent
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(word)) {
                return false;
            }
            if (wordToChar.containsKey(word) && wordToChar.get(word) != c) {
                return false;
            }

            // Add the mappings
            charToWord.put(c, word);
            wordToChar.put(word, c);
        }

        return true;
    }
}
