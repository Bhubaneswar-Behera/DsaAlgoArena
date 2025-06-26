package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * Reference : https://www.youtube.com/watch?v=aZ0B1eWkSVU
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> result = palindromePartitioning.partition(s);
        System.out.println(result);
    }
    //Time Complexity: O(2^n) where n is the length of the string
    //Space Complexity: O(n) for the recursion stack and the result list
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s,  new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s,  List<String> currentPartition, List<List<String>> result) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(0, i + 1);
            if (isPalindrome(substring)) {
                currentPartition.add(substring);
                backtrack(s.substring(i + 1), currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
