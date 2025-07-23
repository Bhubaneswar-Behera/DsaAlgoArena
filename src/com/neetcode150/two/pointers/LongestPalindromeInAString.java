package com.neetcode150.two.pointers;

/**
 *
 * https://www.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 */
public class LongestPalindromeInAString {

    public static void main(String[] args) {
        String s = "anamadam";
        s = longestPalindrome(s);
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        // code here
        int n = s.length();
        String answer = "";

        for (int i = 0; i < n ; i++) {
            String oddPalindrome = oddEven(s, i, i);
            String evenPalindrome = oddEven(s, i, i + 1);
            String max = oddPalindrome.length() > evenPalindrome.length() ? oddPalindrome : evenPalindrome;

            answer = max.length() > answer.length() ? max : answer;
        }
        return answer;
    }

    public static String oddEven(String str, int start, int end) {
        int n = str.length();
        int left = start;
        int right = end;

        while (left >= 0 && right < n) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return str.substring(left + 1, right);

    }
}
