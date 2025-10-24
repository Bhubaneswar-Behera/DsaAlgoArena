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
   public static String minWindow(String s, String t) {
       if (s.length() < t.length()) {
           return "";
       }

       // Step 1: Frequency map of all chars in t
       Map<Character, Integer> targetMap = new HashMap<>();
       for (char c : t.toCharArray()) {
           targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
       }

       int required = targetMap.size(); // how many unique chars to match
       int formed = 0; // how many have matched so far

       // Step 2: Frequency map of all chars in source
       Map<Character, Integer> windowMap = new HashMap<>();

       int left = 0;
       int right = 0;
       int minLen = Integer.MAX_VALUE;
       int start = 0; // to track starting index of result

       // Step 2: Expand the window
       while (right < s.length()) {
           // Add current right char to window map
           char characterRight = s.charAt(right);
           windowMap.put(characterRight, windowMap.getOrDefault(characterRight, 0) + 1);

           // Check if current char count matches target char count
           if (targetMap.containsKey(characterRight)
                   && windowMap.get(characterRight).intValue() == targetMap.get(characterRight).intValue()) {
               formed++;
           }

           // Step 3: Try to shrink from the left
           while (left <= right && formed == required) {
               char characterLeft = s.charAt(left);
               int windowLen = right - left + 1;

               // Update answer if this window is smaller
               if (windowLen < minLen) {
                   minLen = windowLen;
                   start = left;
               }

               // Remove leftmost character
               windowMap.put(characterLeft, windowMap.get(characterLeft) - 1);

               // If removing breaks the match, reduce 'formed'
               if (targetMap.containsKey(characterLeft) && windowMap.get(characterLeft) < targetMap.get(characterLeft)) {
                   formed--;
               }

               left++; // move left pointer
           }

           right++; // expand window
       }

       return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
