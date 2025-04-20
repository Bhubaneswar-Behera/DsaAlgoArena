package com.leetcode.journey.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window Substring: " + minWindow(s, t)); // Output: "BANC"
    }
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        int left = 0; //left pointer for the sliding window.
        int right = 0;//right are pointer for the sliding window.
        int minLength = Integer.MAX_VALUE; //stores the length of the smallest valid window found so far, initialized to the maximum possible value.
        int start = 0; //starting index of the smallest valid window.
        int required = tMap.size(); // Number of unique characters in t
        int formed = 0; // Number of unique characters in the current window that match t

        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            // Add the current character to the window
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // Check if the current character satisfies the frequency requirement
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Remove the leftmost character from the window
                windowMap.put(c, windowMap.get(c) - 1);
                if (tMap.containsKey(c) && windowMap.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            // Expand the window
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
