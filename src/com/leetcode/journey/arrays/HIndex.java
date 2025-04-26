package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class HIndex {
    public static void main(String[] args) {
        HIndex hIndexCalculator = new HIndex();
        int[] citations1 = {3, 0, 6, 1, 5};
        int[] citations2 = {1, 3, 1};

        System.out.println("H-Index for citations1: " + hIndexCalculator.hIndex(citations1)); // Output: 3
        System.out.println("H-Index for citations2: " + hIndexCalculator.hIndex(citations2)); // Output: 1
    }
    public int hIndex(int[] citations) {
        // Step 1: Sort the citations array in descending order
        Arrays.sort(citations);
        int n = citations.length;

        // Step 2: Find the h-index
        for (int i = 0; i < n; i++) {
            int h = n - i; // Number of papers with at least h citations
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0; // If no valid h-index is found
    }


}
