package com.leetcode.journey.strings.hashing.heaps;

/**
 * Check whether the given substring of s is palindrome or not
 * 0<= start<=end<length of s
 *
 * Input:
 * s="anamadamshe" start = 3 end = 7
 * Output: True
 *
 */
public class PalindromeSubstring {
    public static void main(String[] args) {
        String s ="anamadamshe";
        int start = 3;
        int end = 7;
        System.out.println(isPalindrome(s,start,end));
    }
    public static boolean isPalindrome(String str, int start,int end){
        int i = start;
        int j = end;
        while (i < j){
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
