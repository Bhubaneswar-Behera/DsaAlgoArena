package com.neetcode150.array.and.hashing;

import java.util.Arrays;

/**
 *
 * https://neetcode.io/problems/products-of-array-discluding-self
 */
public class ProductsOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        System.out.println("Result: " + Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // Array to store all left multiplication
        int[] left = new int[nums.length];

        // Array to store all right multiplication
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }//after the run output is [1, 1, 2, 8]

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }//after the run output is [48, 24, 12, 2]

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans; // [48, 24, 12, 8]
    }
}
