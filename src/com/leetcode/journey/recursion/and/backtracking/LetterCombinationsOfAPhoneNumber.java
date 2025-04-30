package com.leetcode.journey.recursion.and.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Mapping of digits to letters
        String[] mapping = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        backtrack(result, digits, mapping, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(List<String> result, String digits, String[] mapping, int index, StringBuilder current) {
        // Base case: if the current combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = mapping[digits.charAt(index) - '0'];

        // Iterate through each letter and recurse
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Add the letter to the current combination
            backtrack(result, digits, mapping, index + 1, current); // Recurse for the next digit
            current.deleteCharAt(current.length() - 1); // Backtrack by removing the last letter
        }
    }

}
