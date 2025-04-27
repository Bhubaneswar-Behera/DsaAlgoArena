package com.leetcode.journey.maths.and.bit.manipulation;

/**
 *
 * https://leetcode.com/problems/sqrtx/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SqrtOfX {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x; // The square root of 0 or 1 is the number itself
        }

        int left = 1, right = x, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid * mid is less than or equal to x
            if (mid <= x / mid) {
                result = mid; // Update result to the current mid
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return result;
    }
}
