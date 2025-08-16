package com.neetcode150.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://neetcode.io/problems/minimum-window-with-characters
 * Reference : https://www.youtube.com/watch?v=tMx5JZSBWIE
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
        // Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    }

    // Time Complexity : O(n + m), where:
    //n is the length of the string source.
    //m is the length of the string target.
   public static String minWindow(String source, String target) {
       if (source.length() < target.length()) {
           return "";
       }

       // Frequency of characters in target string
       Map<Character, Integer> targetFreq = new HashMap<>();
       for (char c : target.toCharArray()) {
           targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
       }

       int requiredUniqueChars = targetFreq.size();
       int matchedUniqueChars = 0;

       // Current window frequency
       Map<Character, Integer> windowFreq = new HashMap<>();

       int left = 0, right = 0;
       int minWindowLength = Integer.MAX_VALUE;
       int minWindowStart = 0;

       while (right < source.length()) {
           char rightChar = source.charAt(right);
           windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

           if (targetFreq.containsKey(rightChar) &&
                   windowFreq.get(rightChar).intValue() == targetFreq.get(rightChar).intValue()) {
               matchedUniqueChars++;
           }

           // Try to shrink window from the left if all required chars are matched
           while (matchedUniqueChars == requiredUniqueChars) {

               // Check if the current window is smaller than the previously found minimum window
               int currentWindowLength = right - left + 1;
               if (currentWindowLength < minWindowLength) {
                   // Update the new minimum window length and starting index
                   minWindowLength = currentWindowLength;
                   minWindowStart = left;
               }

               char leftChar = source.charAt(left);
               windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

               // If the character being removed from the left is part of the target string
               // AND its count in the current window falls below the required count,
               // then this window is no longer fully valid → decrease matchedUniqueChars
               if (targetFreq.containsKey(leftChar) &&
                       windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                   matchedUniqueChars--;
               }
               left++;
           }
           right++;
       }

       return minWindowLength == Integer.MAX_VALUE
               ? ""
               : source.substring(minWindowStart, minWindowStart + minWindowLength);
    }
}
