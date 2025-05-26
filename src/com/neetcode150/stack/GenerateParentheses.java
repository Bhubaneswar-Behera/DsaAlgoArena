package com.neetcode150.stack;

import java.util.*;

/**
 *
 * https://neetcode.io/problems/generate-parentheses
 * Reference :
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Helper function to generate parentheses
        generateParenthesis(n, 0,0,result,"");
        return result;
    }
    private static void generateParenthesis(int n, int openingBracket, int closingBracket, List<String> result, String current) {
        // If the current string has reached the maximum length
        /*if (current.length() == 2 * n) {
            result.add(current);
            return;
        }*/
        // If we have used all opening and closing brackets
        if(n == openingBracket && n == closingBracket) {
            result.add(current);
            return;
        }
        // If we have more opening/closing brackets than allowed then we return
        if (n < openingBracket || n < closingBracket) {
            return; // Invalid state
        }

        // If we can add an opening parenthesis
        if (openingBracket < n) {
            generateParenthesis(n, openingBracket + 1, closingBracket, result, current + "(");
        }
        // If we can add a closing parenthesis
        if (closingBracket < openingBracket) {
            generateParenthesis(n, openingBracket, closingBracket + 1, result, current + ")");
        }
    }
}
