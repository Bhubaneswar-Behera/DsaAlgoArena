package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum water a container can store: " + maxArea(height));
    }
    public static int maxArea(int[] height) {
        int left = 0; // Pointer at the beginning
        int right = height.length - 1; // Pointer at the end
        int maxArea = 0; // Variable to store the maximum area

        while (left < right) {
            // Calculate the area
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Update the maximum area if the current area is larger
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // Return the maximum area found
    }
}
