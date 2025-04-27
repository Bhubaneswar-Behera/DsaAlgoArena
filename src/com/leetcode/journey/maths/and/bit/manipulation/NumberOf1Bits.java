package com.leetcode.journey.maths.and.bit.manipulation;

/**
 *
 * https://leetcode.com/problems/number-of-1-bits/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += n & 1; // Check if the least significant bit is 1
            n >>>= 1; // Unsigned right shift to process the next bit
        }

        return count;
    }
}
