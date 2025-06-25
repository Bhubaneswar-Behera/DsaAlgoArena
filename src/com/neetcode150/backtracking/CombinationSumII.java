package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 * Reference : https://www.youtube.com/watch?v=dvZdWR0sHMk&t=162s
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSumII combinationSumII = new CombinationSumII();
        System.out.println(combinationSumII.combinationSum2(candidates, target));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // Early termination if the remaining sum becomes negative
            if (target - candidates[i] < 0) {
                break;
            }
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i + 1);
            current.remove(current.size() - 1);
        }
    }

}
