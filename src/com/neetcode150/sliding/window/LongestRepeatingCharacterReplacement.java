package com.neetcode150.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://neetcode.io/problems/longest-repeating-substring-with-replacement
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "XYYX";
        int k = 2;
        System.out.println(characterReplacement(s, k)); // Output: 4
        //Explanation: Replace the first 'X' with 'Y' and the second 'X' with 'Y' to get "YYYY".
        // The length of the longest substring is 4.
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxCount = 0, left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            maxCount = Math.max(maxCount, freqMap.get(c));

            // If more than k characters need to be replaced
            if ((right - left + 1) - maxCount > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }
}
