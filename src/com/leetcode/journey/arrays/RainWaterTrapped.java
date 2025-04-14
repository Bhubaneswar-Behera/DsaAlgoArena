package com.leetcode.journey.arrays;

/**
 * Company  : Google
 *
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Input Format :First and only argument is the vector A
 * Output Format :Return one integer, the answer to the question
 *
 * Input : A = [0, 1, 0, 2] Output : 1
 * Explanation : 1 unit is trapped on top of the 3rd element.
 *
 * Input : A = [1, 2]  Output : 0
 * Explanation : No water is trapped.
 */
public class RainWaterTrapped {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2};
        System.out.println(trap(A));
    }
    public static int trap(final int[] height) {
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
