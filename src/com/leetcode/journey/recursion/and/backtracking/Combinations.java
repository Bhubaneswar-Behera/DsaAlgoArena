package com.leetcode.journey.recursion.and.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/combinations/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Combinations {

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // Base case: if the current combination has k elements
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through the range [start, n]
        for (int i = start; i <= n; i++) {
            current.add(i); // Add the current number to the combination
            backtrack(result, current, i + 1, n, k); // Recurse with the next number
            current.remove(current.size() - 1); // Backtrack by removing the last number
        }
    }
}
