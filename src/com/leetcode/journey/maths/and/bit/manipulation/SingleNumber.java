package com.leetcode.journey.maths.and.bit.manipulation;

/**
 * LeetCode: 136. Single Number
 * https://leetcode.com/problems/single-number/
 *
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
            answer = answer ^ nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
