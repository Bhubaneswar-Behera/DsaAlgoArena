package com.neetcode150.array.and.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * https://neetcode.io/problems/duplicate-integer
 */

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[]  nums = {1, 2, 3, 3};
        System.out.println(hasDuplicateUsingHashSet(nums));
        System.out.println(hasDuplicate1(nums));
        System.out.println(hasDuplicateUsingBitManipulation(nums));
    }
    public static boolean hasDuplicateUsingHashSet(int[] nums) {
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

    public static boolean hasDuplicateUsingBitManipulation(int[] nums) {
        int bitSet = 0; // Initialize bitSet to track seen numbers

        for (int num : nums) {
            // Check if the bit corresponding to `num` is already set
            if ((bitSet & (1 << num)) != 0) {
                return true; // Duplicate found
            }
            // Set the bit corresponding to `num`
            bitSet |= (1 << num);
        }

        return false; // No duplicates found
    }

    //using HashMap
    public static boolean hasDuplicate1(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1){
                return true;
            }
        }
        return false;
    }
}
