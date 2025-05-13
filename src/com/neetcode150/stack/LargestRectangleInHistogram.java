package com.neetcode150.stack;

import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/largest-rectangle-in-histogram
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {7,1,7,2,2,4};
        System.out.println(largestRectangleArea(heights)); // Output: 8
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
