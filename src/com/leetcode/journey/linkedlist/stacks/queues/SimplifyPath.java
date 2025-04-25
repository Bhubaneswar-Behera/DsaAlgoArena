package com.leetcode.journey.linkedlist.stacks.queues;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println("Simplified Path: " + simplifyPath(path));
    }
    public static String simplifyPath(String path) {
        // Split the path into components
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.equals("..")) {
                // Go to the parent directory (pop from stack if not empty)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.equals(".") && !component.isEmpty()) {
                // Push valid directory or file name onto the stack
                stack.push(component);
            }
        }

        // Rebuild the canonical path
        StringBuilder canonicalPath = new StringBuilder();
        for (String dir : stack) {
            canonicalPath.append("/").append(dir);
        }

        // Return root if stack is empty, otherwise return the canonical path
        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }
}
