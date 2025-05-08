package com.love.babbar.dsa.strings;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.geeksforgeeks.org/print-subsequences-string/
 */
public class PrintAllSubsequencesOfAString {

    public static void main(String[] args) {
        String str = "cab";
        List<String> result = printSubSeq(str);
        System.out.println("All Subsequences of " + str + " are: " + result);
    }

    public static List<String> printSubSeq(String str) {
        List<String> result = new ArrayList<>();
        result.add(""); // start with the empty subsequence

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                // For each existing subsequence, add a new one with the current character
                result.add(result.get(j) + chars[i]);
            }
        }

        return result;
    }
}
