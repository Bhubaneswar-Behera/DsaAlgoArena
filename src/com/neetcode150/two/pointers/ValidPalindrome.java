package com.neetcode150.two.pointers;

/**
 *
 * https://neetcode.io/problems/is-palindrome
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            // Move left pointer to the next valid character
            while (left < n && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous valid character
            while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Check if characters are equal (case insensitive)
            if (left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return  true;
    }
}
