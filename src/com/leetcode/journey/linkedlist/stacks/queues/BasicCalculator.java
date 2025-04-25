package com.leetcode.journey.linkedlist.stacks.queues;


import java.util.Stack;

/**
 *
 *https://leetcode.com/problems/basic-calculator/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BasicCalculator {
    public static void main(String[] args) {
        String s = "1 + 1";
        System.out.println("Result: " + calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int result = 0;
        int sign = 1; // 1 for positive, -1 for negative

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // Build the current number
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+') {
                // Add the current number to the result with its sign
                result += sign * currentNumber;
                currentNumber = 0;
                sign = 1; // Update sign for the next number
            } else if (c == '-') {
                // Add the current number to the result with its sign
                result += sign * currentNumber;
                currentNumber = 0;
                sign = -1; // Update sign for the next number
            } else if (c == '(') {
                // Push the result and sign onto the stack for later
                stack.push(result);
                stack.push(sign);
                result = 0; // Reset result for the new sub-expression
                sign = 1;
            } else if (c == ')') {
                // Add the current number to the result
                result += sign * currentNumber;
                currentNumber = 0;

                // Pop the sign and previous result from the stack
                result *= stack.pop(); // Apply the sign
                result += stack.pop(); // Add the previous result
            }
        }

        // Add the last number to the result
        result += sign * currentNumber;
        return result;
    }
}
