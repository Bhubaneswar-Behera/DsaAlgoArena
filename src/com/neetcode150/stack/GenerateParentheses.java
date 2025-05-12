package com.neetcode150.stack;

import java.util.*;

/**
 *
 * https://neetcode.io/problems/generate-parentheses
 */
public class GenerateParentheses {

    static class Node {
        String current;
        int open;
        int close;

        Node(String current, int open, int close) {
            this.current = current;
            this.open = open;
            this.close = close;
        }
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> closeStack = new Stack<>();

        stack.push("");
        openStack.push(0);
        closeStack.push(0);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            int open = openStack.pop();
            int close = closeStack.pop();

            if (open == n && close == n) {
                result.add(current);
                continue;
            }

            if (open < n) {
                stack.push(current + "(");
                openStack.push(open + 1);
                closeStack.push(close);
            }

            if (close < open) {
                stack.push(current + ")");
                openStack.push(open);
                closeStack.push(close + 1);
            }
        }

        return result;

    }
}
