package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private  void backtrack(List<List<Integer>> result, List<Integer> current,int[] nums) {
        // Base case: if the current permutation is of the same length as nums
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            // If the number is already in the current permutation, skip it
            if (current.contains(num)) {
                continue;
            }
            // Add the number to the current permutation and backtrack
            current.add(num);
            // Recursive call to continue building the permutation
            backtrack(result, current,nums);
            // Remove the last added number to backtrack
            current.remove(current.size() - 1);
        }
    }
}
