package com.neetcode150.dp.one.dimensional;

/**
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Reference : https://www.youtube.com/watch?v=Y6B-7ZctiW8
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums)); // Output: 6
        // Explanation: The subarray [2, 3] has the largest product 6.
    }
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        long leftProduct = 1;
        long rightProduct = 1;
        long ans = nums[0];

        for (int i = 0; i < n; i++) {

            //if any of leftProduct or rightProduct become 0 then update it to 1
            leftProduct = (leftProduct == 0 ) ? 1 : leftProduct;
            rightProduct = (rightProduct == 0 ) ? 1 : rightProduct;

            //prefix product
            leftProduct = leftProduct * nums[i];

            //suffix product
            rightProduct = rightProduct * nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return (int) ans;
    }
}
