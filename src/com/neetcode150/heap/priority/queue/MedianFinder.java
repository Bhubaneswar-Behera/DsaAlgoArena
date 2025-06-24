package com.neetcode150.heap.priority.queue;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/find-median-from-data-stream/
 * Reference : https://www.youtube.com/watch?v=c9Myn-zYmJs&t=15128s
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        // Max heap for the lower half of the numbers
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Min heap for the upper half of the numbers
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Add to max-heap first
        maxHeap.offer(num);

        // Ensure the largest of the max-heap is less than or equal to the smallest of the min-heap
        minHeap.offer(maxHeap.poll());


        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
