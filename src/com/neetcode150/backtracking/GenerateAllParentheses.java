package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: https://leetcode.com/problems/generate-parentheses/description/
 *
 * Given an integer A pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses of length 2*A.
 *
 * Input : A = 3
 * Output : [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * Explanation : All paranthesis are given in the output list.
 *
 * Input : A = 1
 * Output : [ "()" ]
 * Explanation : All paranthesis are given in the output list.
 *
 *
 */
public class GenerateAllParentheses {

    public static void main(String[] args) {
        int A = 3;
        List<String> result = generateParentheses(A);
        System.out.println(result);

    }
    public static List<String> generateParentheses(int A) {
        List<String> result = new ArrayList<>();
        // Helper function to generate parentheses
        generateParenthesis(A, 0,0,result,"");
        return result;
    }
    private static void generateParenthesis(int n, int openingBracket, int closingBracket, List<String> result, String current) {
        // If we have used all opening and closing brackets
        if(n == openingBracket && n == closingBracket) {
            result.add(current);
            return;
        }
        // If we have more opening/closing brackets than allowed then we return


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
