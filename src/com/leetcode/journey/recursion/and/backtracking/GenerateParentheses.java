package com.leetcode.journey.recursion.and.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GenerateParentheses {

    public static void main(String[] args) {
            int n = 3;
            System.out.println(generateParenthesis(n));
        }

        public static List<String> generateParenthesis ( int n){
            List<String> result = new ArrayList<>();
            backtrack(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        private static void backtrack (List < String > result, StringBuilder current,int open, int close, int max){
            // Base case: if the current combination is complete
            if (current.length() == max * 2) {
                result.add(current.toString());
                return;
            }

            // Add an opening parenthesis if we can
            if (open < max) {
                current.append('(');
                backtrack(result, current, open + 1, close, max);
                current.deleteCharAt(current.length() - 1); // Backtrack
            }

            // Add a closing parenthesis if it won't exceed the number of opening parentheses
            if (close < open) {
                current.append(')');
                backtrack(result, current, open, close + 1, max);
                current.deleteCharAt(current.length() - 1); // Backtrack
            }
        }
}
