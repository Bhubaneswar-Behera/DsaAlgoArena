package com.neetcode150.heap.priority.queue;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
 * Reference : https://www.youtube.com/watch?v=i7Mt70QERw4
 */
public class KthLargestInAStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public static void main(String[] args) {
        // Example usage
        KthLargestInAStream kthLargest = new KthLargestInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3)); // Returns 4
        System.out.println(kthLargest.add(5)); // Returns 5
        System.out.println(kthLargest.add(10)); // Returns 5
        System.out.println(kthLargest.add(9)); // Returns 8
        System.out.println(kthLargest.add(4)); // Returns 8
    }
    public KthLargestInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k); // Min-heap with a capacity of k

        // Add initial elements to the heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll(); // Remove the smallest element
            minHeap.offer(val); // Add the new value
        }

        return minHeap.peek(); // Return the kth largest element
    }
}
