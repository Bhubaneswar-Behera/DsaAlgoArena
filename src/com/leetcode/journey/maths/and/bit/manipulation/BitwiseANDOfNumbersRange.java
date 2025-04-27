package com.leetcode.journey.maths.and.bit.manipulation;

/**
 *
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Find the common prefix
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        // Shift the common prefix back to its original position
        return left << shift;
    }
}
