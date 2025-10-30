package com.neetcode150.stack;

import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/largest-rectangle-in-histogram
 * Reference : https://www.youtube.com/watch?v=ysy1o-QEj3k&t=377s
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2,4};
        System.out.println(largestRectangleArea(heights)); // Output: 10
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        //left smallest nearest element
        int[] leftSmallest = new int[n];
        for (int i = 0; i < n; i++) {
            // If the stack is not empty, we pop elements until we find a smaller element
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmallest[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        //Right smallest nearest element
        int[] rightSmallest = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // If the stack is not empty, we pop elements until we find a smaller element
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If stack is empty, it means there is no smaller element to the right
            // we have to use n as the right boundary
            rightSmallest[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // Calculate the maximum area
        for (int i = 0; i < n ; i++) {
            int width = rightSmallest[i] - leftSmallest[i] - 1;
            int currentArea = heights[i] * width;
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}
