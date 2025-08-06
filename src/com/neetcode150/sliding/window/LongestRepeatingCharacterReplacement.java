package com.neetcode150.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://neetcode.io/problems/longest-repeating-substring-with-replacement
 * Reference : https://www.youtube.com/watch?v=ExY8svHF_Eo
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k)); // Output: 4
        //Explanation: The substring "AABAB" can be replaced with "AAAAA" by replacing one 'B' with 'A', resulting in a length of 5.
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int left = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);

            maxFreq = Math.max(maxFreq, freqMap.get(currentChar));
            int windowSize = right - left + 1;

            if (windowSize - maxFreq > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return maxWindow;
    }

    public static int characterReplacement1(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {

            // Update the frequency of the current character
            char currentChar = s.charAt(right);
            freq[currentChar - 'A']++;

            // Update the max frequency
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']);

            int windowLength = right - left + 1;

            // If the windowLength - max frequency > k,
            // then we need to shrink the window
            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowLength = right - left + 1;
            maxWindow = Math.max(maxWindow, windowLength);
        }

        return maxWindow;
    }
}
