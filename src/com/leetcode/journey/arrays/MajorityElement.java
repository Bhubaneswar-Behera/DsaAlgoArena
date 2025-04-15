package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        System.out.println(majorityElement(A));
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0 ; i < n;i++){
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else{
                if(majority == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < n ;i++) {
            if(majority == nums[i]){
                count++;
            }
        }
        if(count > n/2){
            return majority;
        }
        return majority;
    }
}
