package com.neetcode150.stack;

import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/evaluate-reverse-polish-notation
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"1","2","+","3","*","4","-"};
        System.out.println(evalRPN(tokens));
        // Output: 5
        // Explanation: ((1 + 2) * 3) - 4 = 5
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Check if token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (token) {
                    case "+": result = a + b; break; // Integer Addition
                    case "-": result = a - b; break; // Integer Subtraction
                    case "*": result = a * b; break; // Integer Multiplication
                    case "/": result = a / b; break; // Integer division
                }

                stack.push(result);
            } else {
                // Token is a number
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
