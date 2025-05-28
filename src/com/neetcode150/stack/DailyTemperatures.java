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
        Stack<Integer> stack = new Stack<>();

        int n = temperatures.length;
        int[] answer = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            // Popping all indices with a lower or equal
            // temperature than the current index
            while(!stack.isEmpty()
                    && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // If the stack still has elements,
            // then the next warmer temperature exists!
            if(!stack.isEmpty()) {
                //Subtracting the current index i from the index of the next warmer day (stack.peek())
                // gives the difference in days between the two indices,
                // which represents how many days you need to wait for a warmer temperature.
                answer[i] = stack.peek() - i;
            }

            // Inserting current index in the stack
            stack.push(i);
        }

        return answer;
    }

    public static int[] dailyTemperatures1(int[] temperatures) {
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
