package com.love.babbar.dsa.strings;

/**
 *
 * https://www.geeksforgeeks.org/problems/palindrome-string0817/1
 */
public class PalindromeString {

    public static void main(String[] args) {
        String str = "aba";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s) {
        // code here
        int n = s.length();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
