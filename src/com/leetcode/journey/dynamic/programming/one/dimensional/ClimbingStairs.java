package com.leetcode.journey.dynamic.programming.one.dimensional;

/**
 *
 * https://leetcode.com/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n)); // Output: 2
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }

        return second;
    }
}
