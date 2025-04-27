package com.leetcode.journey.maths.and.bit.manipulation;

/**
 *
 * https://leetcode.com/problems/powx-n/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class PowOfXToThePowerN  {
    public static void main(String[] args) {
        PowOfXToThePowerN solution = new PowOfXToThePowerN();

        double x = 2.00000;
        int n = 10;
        System.out.println("Input: x = " + x + ", n = " + n + ", Output: " + solution.myPow(x, n)); // Expected: 1024.00000
    }

    public double myPow(double x, int n) {
        long N = n; // handle overflow when n = Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        while (N > 0) {
            if (N % 2 == 1) { // if N is odd
                result *= x;
            }
            x *= x; // square the base
            N /= 2; // divide exponent by 2
        }
        return result;
    }
}
