package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        TwoSumII twoSumII = new TwoSumII();
        int[] result = twoSumII.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
    public int[] twoSum(int[] numbers, int target) {
       int n = numbers.length;
       int left = 0;
       int right = n - 1;
         while (left < right) {
              int sum = numbers[left] + numbers[right];
              if (sum == target) {
                return new int[]{left + 1, right + 1};
              } else if (sum < target) {
                left++;
              } else {
                right--;
              }
         }
        return new int[]{-1, -1};
    }
}
