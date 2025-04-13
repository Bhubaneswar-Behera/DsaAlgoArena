package com.leetcode.journey.strings.hashing.heaps;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String str = "babad";//Output: "bab"
        LongestPalindromeSubString longestPalindromeSubString = new LongestPalindromeSubString();
        System.out.println(longestPalindromeSubString.longestPalindrome(str));
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // Even length palindrome
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
