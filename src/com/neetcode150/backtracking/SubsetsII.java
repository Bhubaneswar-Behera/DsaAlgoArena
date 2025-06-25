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
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        // Start backtracking from the beginning
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }
    private void backtrack(List<List<Integer>> resultSets, List<Integer> current,
                           int[] nums, int start) {
        // If the set is already present, just continue
        if (resultSets.contains((current))){
            return;
        }

        resultSets.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Case of including the number
            current.add(nums[i]);

            // Backtrack the new subset
            backtrack(resultSets, current, nums, i + 1);

            // Case of not-including the number
            current.remove(current.size() - 1);
        }
    }

}
