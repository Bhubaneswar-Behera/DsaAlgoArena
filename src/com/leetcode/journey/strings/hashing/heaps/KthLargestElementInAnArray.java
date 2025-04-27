package com.leetcode.journey.strings.hashing.heaps;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();

        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Input: nums = [3,2,1,5,6,4], k = 2, Output: " + solution.findKthLargest(nums1, k1)); // Expected: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Input: nums = [3,2,3,1,2,4,5,5,6], k = 4, Output: " + solution.findKthLargest(nums2, k2)); // Expected: 4
    }
    public static int findKthLargest(int[] nums, int k) {
// Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num); // Add the current number to the heap

            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}
