package com.love.babbar.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number is: " + findDuplicate(arr));
    }
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int answer = 0;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i] , 0)+ 1 );
        }


        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                answer = entry.getKey();
                break;
            }
        }

        return answer ;

    }
}
