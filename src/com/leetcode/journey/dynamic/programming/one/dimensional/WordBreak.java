package com.leetcode.journey.dynamic.programming.one.dimensional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/word-break/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordBreak(s, wordDict)); // Output: true
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert list to set for faster lookup
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Base case: empty string can be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
