package com.neetcode150.stack;

import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/daily-temperatures
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {30,38,30,36,35,40,28};
        System.out.println(dailyTemperatures(temperatures));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        for (int i = 0; i < n; i++) {
            // Pop indices from stack until the current temp is not warmer
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // Days to wait
            }
            stack.push(i); // Push current index
        }

        // Remaining indices in the stack have no warmer day → already 0
        return result;
    }
}
