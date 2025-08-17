package com.neetcode150.stack;

import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/minimum-stack
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top());    // Output: 0
        System.out.println(minStack.getMin()); // Output: -2
    }

    // A stack that supports push, pop, top, and retrieving the minimum element in constant time.
    private Stack<Integer> stack = new Stack<>();

    // A secondary stack to keep track of the minimum elements.
    private Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        // Push the new minimum value onto the minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        int removed = stack.pop();
        // If the popped value is the current minimum, pop it from minStack as well
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
