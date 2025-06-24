package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/combination-sum/description/
 * Reference: https://www.youtube.com/watch?v=jkgZw2WEaqA
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(nums, target);
        System.out.println(result);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] nums, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {// found a valid combination
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index >= nums.length) { // no valid combination
            return;
        }
        // Include the current candidate
        current.add(nums[index]);

        // Recur with the same index to allow for reuse of the same element
        backtrack(nums, target - nums[index], index, current, result); // Reuse the same element

        // Backtrack: remove the last added element
        current.remove(current.size() - 1);

        // Exclude the current candidate and move to the next
        backtrack(nums, target, index + 1, current, result);
    }
}
