package com.leetcode.journey.strings.hashing.heaps;

/**
 * Given a String s, find the length of the longest palindromic substring of
 * s.
 * Input : S = "anamadam"
 * Output : 5
 * Explanation: "madam" is the longest palindromic substring as compare to
 *              "ana" and "ama"
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "anamadam";
        System.out.println(longestPalindromicSubstring(s));
    }
    public static int longestPalindromicSubstring(String str){
        int maxLength = 0;
        int n = str.length();;

        //for odd length , 1 center
        for (int i = 0; i < n ; i++) {
            int left = i;
            int right  = i;
            while (left >=0 && right < n){
                if (str.charAt(left) != str.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            maxLength =Math.max(maxLength, right - left -1);
        }

        //for even length, 2 center
        for (int i = 0; i < n ; i++) {
            int left = i;
            int right  = i+1;
            while (left >=0 && right < n){
                if (str.charAt(left) != str.charAt(right)){
                    break;
                }
                left--;
                right++;
            }
            maxLength =Math.max(maxLength, right - left -1);
        }
        return maxLength;
    }
}
