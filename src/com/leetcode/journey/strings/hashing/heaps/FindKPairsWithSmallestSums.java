package com.leetcode.journey.strings.hashing.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        System.out.println("Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3");
        System.out.println("Output: " + kSmallestPairs(nums1, nums2, k)); // Expected: [[1,2],[1,4],[1,6]]
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap to store pairs with their sums
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        // Initialize the heap with the first element of nums1 paired with all elements of nums2
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{i, 0}); // Pair (nums1[i], nums2[0])
        }

        // Extract the smallest pairs from the heap
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int i = current[0], j = current[1];
            result.add(List.of(nums1[i], nums2[j]));

            // If there is a next element in nums2, add the next pair to the heap
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }

            k--;
        }

        return result;
    }
}
