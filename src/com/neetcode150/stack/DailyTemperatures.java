package com.neetcode150.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/daily-temperatures
 * Reference : https://www.youtube.com/watch?v=ekFs9Nb2RNQ
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures = {30,38,30,36,35,40,28};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures1(temperatures)));//use this
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

    public static int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> helperStack = new Stack<>();

        int totalDays = temperatures.length;
        int[] daysToWait = new int[totalDays];

        for(int currentDay = totalDays - 1; currentDay >= 0; currentDay--) {

            // Popping all indices with a lower or equal
            // temperature than the current index
            while(!helperStack.isEmpty()
                    && temperatures[currentDay] >= temperatures[helperStack.peek()]) {
                helperStack.pop();
            }

            // If the stack still has elements,
            // then the next warmer temperature exists!
            if(!helperStack.isEmpty()) {
                daysToWait[currentDay] = helperStack.peek() - currentDay;
            }

            // Inserting current index in the stack
            helperStack.push(currentDay);
        }

        return daysToWait;
    }
}
