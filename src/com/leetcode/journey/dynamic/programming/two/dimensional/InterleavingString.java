package com.leetcode.journey.dynamic.programming.two.dimensional;

/**
 *
 * https://leetcode.com/problems/interleaving-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class InterleavingString {

    public static void main(String[] args) {
        InterleavingString solver = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solver.isInterleave(s1, s2, s3)); // Output: true
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        // If lengths don't match, return false
        if (m + n != s3.length()) {
            return false;
        }

        // Create a DP table
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true; // Base case
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        // Return the result
        return dp[m][n];
    }
}
