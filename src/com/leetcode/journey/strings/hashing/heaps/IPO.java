package com.leetcode.journey.strings.hashing.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/ipo/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IPO {


    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.println("Input: k = " + k + ", w = " + w + ", profits = [1,2,3], capital = [0,1,1]");
        System.out.println("Output: " + findMaximizedCapital(k, w, profits, capital)); // Expected: 4
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
// Min-heap to store projects by their required capital
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Max-heap to store profits of projects that can be started
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Add all projects to the min-heap
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Perform up to k iterations
        for (int i = 0; i < k; i++) {
            // Move all projects that can be started with the current capital to the max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }

            // If no projects can be started, break
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Pick the most profitable project
            w += maxProfitHeap.poll();
        }

        return w;
    }
}
