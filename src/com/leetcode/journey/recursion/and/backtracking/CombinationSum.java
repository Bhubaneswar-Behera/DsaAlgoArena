package com.leetcode.journey.recursion.and.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/combination-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: if the target is 0, add the current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through the candidates starting from the current index
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) { // Only proceed if the candidate is less than or equal to the target
                current.add(candidates[i]); // Add the candidate to the current combination
                backtrack(candidates, target - candidates[i], i, current, result); // Recurse with the reduced target
                current.remove(current.size() - 1); // Backtrack by removing the last added candidate
            }
        }
    }
}
