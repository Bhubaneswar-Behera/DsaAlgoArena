package com.neetcode150.array.and.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://neetcode.io/problems/duplicate-integer
 */

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[]  nums = {1, 2, 3, 3};
        System.out.println(hasDuplicate(nums));
    }
    public static boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> hashSet = new HashSet<>();

        for(int num: nums){
            if(!hashSet.add(num)){
                return true;
            }
            hashSet.add(num);
        }

        return false;
    }
}
