package com.leetcode.journey.strings.hashing.heaps;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s)); // Output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // Remove characters from the set until the duplicate is removed
            while (set.contains(currentChar)) {
                set.remove(s.charAt(start));
                start++;
            }

            // Add the current character to the set
            set.add(currentChar);

            // Update the maximum length
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
