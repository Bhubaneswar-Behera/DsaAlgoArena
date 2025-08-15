package com.neetcode150.dp.one.dimensional;

/**
 *
 * https://leetcode.com/problems/decode-ways/description/
 * Reference : https://www.youtube.com/watch?v=FEkZxCl_-ik
 */
public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings(s));
        // Output: 3
        // Explanation: It can be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
