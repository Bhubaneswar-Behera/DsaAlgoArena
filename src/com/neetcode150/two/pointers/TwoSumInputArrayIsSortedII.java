package com.neetcode150.two.pointers;

import java.util.Arrays;

/**
 *
 * https://neetcode.io/problems/two-integer-sum-ii
 *
 * Two Sum II - Input Array Is Sorted
 */
public class TwoSumInputArrayIsSortedII {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int target = 3;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
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
        return new int[]{-1, -1}; // Return an invalid result if no solution is found
    }
}
