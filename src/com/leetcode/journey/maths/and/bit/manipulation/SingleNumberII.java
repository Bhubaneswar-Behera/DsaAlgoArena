package com.leetcode.journey.maths.and.bit.manipulation;

/**
 *
 * https://leetcode.com/problems/single-number-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}
