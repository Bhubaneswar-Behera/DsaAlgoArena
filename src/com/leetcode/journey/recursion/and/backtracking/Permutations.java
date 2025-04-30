package com.leetcode.journey.recursion.and.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *https://leetcode.com/problems/permutations/?envType=study-plan-v2&envId=top-interview-150
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current) {
        // Base case: if the current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through the numbers
        for (int num : nums) {
            if (current.contains(num)) {
                continue; // Skip already used numbers
            }
            current.add(num); // Add the number to the current permutation
            backtrack(nums, result, current); // Recurse
            current.remove(current.size() - 1); // Backtrack by removing the last number
        }
    }
}
