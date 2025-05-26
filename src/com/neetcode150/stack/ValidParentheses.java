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
                // If the stack is empty or the top of the stack does not match the current character, return false
                if (characterStack.isEmpty()) {
                    return false;
                }
                char top = characterStack.peek();
                if(c == ')' && top == '(') {
                   characterStack.pop();
                } else if ( c == '}' && top == '{') {
                    characterStack.pop();
                } else if (c == ']' && top == '[') {
                    characterStack.pop();
                } else {
                    // If the current character does not match the top of the stack, return false
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }
}
