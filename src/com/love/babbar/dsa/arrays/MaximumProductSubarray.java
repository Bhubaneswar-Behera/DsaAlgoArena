package com.love.babbar.dsa.arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1
 * Reference : https://www.youtube.com/watch?v=Y6B-7ZctiW8
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums)); // Output: 6
    }

    // Function to find maximum product subarray
    public static int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int answer = arr[0];

        for (int i = 1; i < n; i++) {
            leftProduct = leftProduct == 0  ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

        //prefix product
         leftProduct = leftProduct * arr[i];

         //suffix product
          rightProduct = rightProduct * arr[n - i - 1];

            answer = Math.max(answer, Math.max(leftProduct, rightProduct));
        }
        return (int) answer;
    }
}
