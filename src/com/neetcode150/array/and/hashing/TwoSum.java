package com.neetcode150.array.and.hashing;

import java.util.*;

/**
 *
 * https://neetcode.io/problems/two-integer-sum
 * Return indices of two numbers such that they add up to a specific target.
 */
public class TwoSum {
    public static void main(String[] args) {
       int[] nums =  {3,4,5,6};
       int target = 7;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            int[] result = new int[2];
             Map<Integer, Integer> hashMap = new HashMap<>();

            for(int i = 0 ; i< n ;i++){
                int delta = target - nums[i];
               if (hashMap.containsKey(delta)) {
                    result[0] = i;
                    result[1] = hashMap.get(delta);
                    return result;
                }
                    hashMap.put(nums[i], i);
            }

            return new int[]{-1,-1};
    }
}
