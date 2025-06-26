package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Reference : https://www.youtube.com/watch?v=yRGbs6KCe9Y
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        String digits = "23";
        List<String> result = letterCombinationsOfAPhoneNumber.letterCombinations(digits);
        System.out.println(result);
    }
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character,String> map = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
        );

        List<String> result = new ArrayList<>();
        backtrack(digits, map,0,"", result);
        return result;
    }
    private void backtrack(String digits, Map<Character,String> map, int index, String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, map, index + 1, current + letters.charAt(i), result);
        }
    }
}
