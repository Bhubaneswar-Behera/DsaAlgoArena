package com.leetcode.journey.strings.hashing.heaps;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/find-median-from-data-stream/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);    // arr = [1, 2, 3]
        System.out.println(medianFinder.findMedian()); // Output: 2.0
    }

    private PriorityQueue<Integer> maxHeap; // Max-heap for the smaller half
    private PriorityQueue<Integer> minHeap; // Min-heap for the larger half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max-heap
        minHeap = new PriorityQueue<>(); // Min-heap
    }

    public void addNum(int num) {
        // Add to max-heap first
        maxHeap.offer(num);

        // Balance the heaps: Ensure all elements in maxHeap are <= elements in minHeap
        minHeap.offer(maxHeap.poll());

        // Maintain size property: maxHeap can have at most one more element than minHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // Odd number of elements
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // Even number of elements
        }
    }

}
