package com.leetcode.journey.maths.and.bit.manipulation;

/**
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        FactorialTrailingZeroes solution = new FactorialTrailingZeroes();

        // Test case 1
        int n1 = 3;
        System.out.println("Input: " + n1 + ", Output: " + solution.trailingZeroes(n1)); // Expected: 0

        // Test case 2
        int n2 = 5;
        System.out.println("Input: " + n2 + ", Output: " + solution.trailingZeroes(n2)); // Expected: 1

        // Test case 3
        int n3 = 10;
        System.out.println("Input: " + n3 + ", Output: " + solution.trailingZeroes(n3)); // Expected: 2

        // Test case 4
        int n4 = 25;
        System.out.println("Input: " + n4 + ", Output: " + solution.trailingZeroes(n4)); // Expected: 6
    }
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5; // Count the number of multiples of 5
            count += n;
        }
        return count;
    }
}
