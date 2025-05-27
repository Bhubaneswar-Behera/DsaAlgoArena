package com.neetcode150.two.pointers;

/**
 *
 * https://neetcode.io/problems/max-water-container
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,7,2,5,4,7,3,6};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, width * height);

            // Move the pointer pointing to the taller line that could increase the area.
            if (heights[left] < heights[right]) {
                left++;
            }
            //Otherwise, the right pointer is
            // decremented (right--) to potentially find a taller line on the right side.
            else {
                right--;
            }
        }
        return maxArea;
    }
}
