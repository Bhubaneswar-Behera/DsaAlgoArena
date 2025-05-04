package com.leetcode.journey.dynamic.programming.two.dimensional;

/**
 *
 * https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class EditDistance {

    public static void main(String[] args) {
        EditDistance solver = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(solver.minDistance(word1, word2)); // Output: 3
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // Insert all characters of word2
                } else if (j == 0) {
                    dp[i][j] = i; // Delete all characters of word1
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                            Math.min(dp[i - 1][j],   // Delete
                                    dp[i][j - 1])); // Insert
                }
            }
        }

        // Return the result
        return dp[m][n];
    }


}
