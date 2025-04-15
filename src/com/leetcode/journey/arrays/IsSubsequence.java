package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "ace";
        String t = "abcde";
        System.out.println(isSubsequence(s, t)); // Output: true
    }
    public static boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;
        int sLength = s.length();
        int tLength = t.length();

        while (sPointer < sLength && tPointer < tLength) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }
        return sPointer == s.length();
    }
}
