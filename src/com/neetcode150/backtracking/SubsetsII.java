package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/subsets-ii/description/
 * Reference: https://www.youtube.com/watch?v=qGyyzpNlMDU&t=6s
 */
public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsII subsetsII = new SubsetsII();
        System.out.println(subsetsII.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // Start backtracking from the beginning
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> current,
                           int[] nums, int start) {
        // If the set is already present, just continue
        if (result.contains((current))){
            return;
        }

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Case of including the number
            current.add(nums[i]);

            // Backtrack the new subset
            backtrack(result, current, nums, i + 1);

            // Case of not-including the number
            current.remove(current.size() - 1);
        }
    }

}
