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
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int answer = 0;
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1] ,height[i] );
        }

        for (int i = n-2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i = 0; i < n ; i++) {
            answer = answer + Math.min(leftMax[i] ,rightMax[i] ) - height[i];
        }

        return answer;
    }
}
