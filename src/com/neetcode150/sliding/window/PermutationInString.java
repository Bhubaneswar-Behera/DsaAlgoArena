package com.neetcode150.sliding.window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://neetcode.io/problems/permutation-string
 */
public class PermutationInString {

    public static void main(String[] args) {
        String  s1 = "abc";
        String s2 = "lecabee";
        System.out.println(checkInclusion(s1, s2)); // Output: true
        // Explanation: The substring "cba" is a permutation of "abc".
    }
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        // Sort s1
        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        String sortedS1 = new String(s1Chars);

        // Check every substring of s2 with length equal to s1
        for (int i = 0; i <= len2 - len1; i++) {
            String sub = s2.substring(i, i + len1);
            char[] subChars = sub.toCharArray();
            Arrays.sort(subChars);
            if (sortedS1.equals(new String(subChars))) {
                return true;
            }
        }

        return false;
    }
}
