package com.leetcode.journey.maths.and.bit.manipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 *
 */
public class FindTheDuplicateNumber {
    public static int findDuplicateBruteForce(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Map<Integer,Integer> hmap = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : hmap.keySet()) {
            if (hmap.get(key) > 1) {
                answer = key;
                break;
            }

        }
        return answer;
    }
    public static int findDuplicateUsingBitManipulation(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
            answer = answer ^ nums[i];
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicateUsingBitManipulation(nums));
        System.out.println(findDuplicateBruteForce(nums));
    }
}
