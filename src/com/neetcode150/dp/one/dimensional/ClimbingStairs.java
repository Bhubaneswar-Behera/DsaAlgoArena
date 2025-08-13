package com.neetcode150.dp.one.dimensional;

/**
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 * Reference : https://www.youtube.com/watch?v=UUaMrNOvSqg
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(2)); // Output: 1
        System.out.println(climbingStairs.climbStairs(3)); // Output: 3
    }
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n+ 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n ;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }
}
