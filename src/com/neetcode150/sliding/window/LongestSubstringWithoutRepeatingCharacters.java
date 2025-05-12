package com.neetcode150.sliding.window;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://neetcode.io/problems/longest-substring-without-duplicates
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "zxyzxyz";
        System.out.println(lengthOfLongestSubstring(s));
        // Output: 3
        // Explanation: The answer is "xyz", with the length of 3.
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (hashSet.contains(s.charAt(right))) {
                hashSet.remove(s.charAt(left));
                left++; // shrink window from left
            }
            hashSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
