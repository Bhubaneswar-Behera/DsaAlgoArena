package com.neetcode150.stack;

import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/validate-parentheses
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String  s = "[]";
        System.out.println(isValid(s)); // Output: true
    }

    public static boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                characterStack.push(c);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                }
                char top = characterStack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }
}
