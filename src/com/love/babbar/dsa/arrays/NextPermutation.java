package com.love.babbar.dsa.arrays;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/next-permutation/description/
 * https://www.youtube.com/watch?v=6ENl3OwwxLg
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println("Next Permutation: "+ Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        //null check
        if(nums == null || nums.length == 0){
            return;
        }
        int n = nums.length;
        int k = n - 2; //as last element is already in the proper place

        //find the first decreasing element
        for (int i = n - 1; i > 0 ; i--) {
            if(nums[i] <= nums[i-1]){ //equal to as arrays can have duplicate
                k = k - 1;
            } else {
                break;
            }
        }

        //k ==-1 . that is start of the array
        //then do reverse
        if(k == -1){
            reverse(nums, 0, n - 1);
            return;
        }
        //else find the first element which is greater than nums[k]
        for (int i = n - 1; i > 0 ; i--) {
            if(nums[i] > nums[k]){
                //swap
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        //finally reverse it
        reverse(nums,k + 1, n - 1);

    }

    public static void reverse(int[] arr, int start, int end){
        int i = start;
        int j = end;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
