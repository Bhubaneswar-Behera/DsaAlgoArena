package com.leetcode.journey.maths.and.bit.manipulation;

/**
 *
 * https://leetcode.com/problems/reverse-bits/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit of n
            int bit = n & 1;

            // Shift result to the left and add the extracted bit
            result = (result << 1) | bit;

            // Shift n to the right to process the next bit
            n >>= 1;
        }

        return result;
    }
}
