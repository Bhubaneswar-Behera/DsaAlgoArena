package com.leetcode.journey.linkedlist.stacks.queues;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Push the new minimum onto the minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // If the top of stack equals the top of minStack, pop from minStack as well
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}