package com.neetcode150.two.pointers;

/**
 *
 * https://neetcode.io/problems/trapping-rain-water
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0,2,0,3,1,0,1,3,2,1};
        System.out.println(trap(height)); // Output: 9
    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped = waterTrapped +  leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped = waterTrapped +  rightMax - height[right];
                right--;
            }
        }
        return waterTrapped;
    }
}
