package com.neetcode150.dp.one.dimensional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/word-break/description/
 * Reference : https://www.youtube.com/watch?v=hK6Git1o42c
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict)); // Output: true
        // Explanation: T he string "leetcode" can be segmented into "leet" and "code".
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        // Convert the dictionary to a set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);

        // Find the maximum word length in the dictionary
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();
        // dp[i] states if the substring s[0..i] can be segmented
        boolean[] dp = new boolean[n + 1];

        // Base case: empty string is valid
        dp[0] = true;

        for (int i = 1; i <= n; i++)

            // Check prefixes of length up to maxLen
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further prefixes
                }
            }

        return dp[n];
    }
}
