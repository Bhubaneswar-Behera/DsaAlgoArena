package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/subsets/description/
 * Reference: https://www.youtube.com/watch?v=kYY9DotIKlo&t=1803s
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        // Start backtracking from the beginning
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }
    private void backtrack(List<List<Integer>> resultSets, List<Integer> current,
                           int[] nums, int index) {
        // Add the set to result set
        resultSets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {

            // Case of including the number
            current.add(nums[i]);

            // Backtrack the new subset
            backtrack(resultSets, current, nums, i + 1);

            // Case of not-including the number
            current.remove(current.size() - 1);
        }
    }
}
