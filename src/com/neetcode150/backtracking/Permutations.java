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
        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    private  void backtrack(List<List<Integer>> result, List<Integer> current,int[] nums) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }
            current.add(num);
            backtrack(result, current,nums);
            current.remove(current.size() - 1);
        }
    }
}
