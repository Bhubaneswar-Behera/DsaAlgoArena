package com.love.babbar.dsa.arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/palindromic-array-1587115620/1
 */
public class PalindromicArray {

    public static void main(String[] args) {
        int[] arr = {111, 222, 333, 444, 555};
        System.out.println(isPalindromeArray(arr));
    }

    public static boolean isPalindromeArray(int[] arr) {
        // add code here.
        int n = arr.length;
        for (int i = 0; i < n ; i++) {
            int currentNumber = arr[i];
            if(!isPalindrome(currentNumber)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(int num){
        int i = 0;
        int j = String.valueOf(num).length() - 1;

        while (i < j){
            if (String.valueOf(num).charAt(i) != String.valueOf(num).charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
