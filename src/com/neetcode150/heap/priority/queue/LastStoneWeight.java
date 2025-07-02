package com.neetcode150.heap.priority.queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/last-stone-weight/description/
 * Reference : https://www.youtube.com/watch?v=8txOQt0ZwTg
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        // Example usage
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones)); // Output: 1
    }
    public static int lastStoneWeight(int[] stones) {
        // Create a priority queue
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the priority queue
        for (int stone : stones) {
            pq.add(stone);
        }

        // While there are more than 1 stone
        while (pq.size() > 1) {

            // Get the two heaviest stones
            int y = pq.poll();
            int x = pq.poll();

            // If the stones are not equal
            if (x != y) {
                pq.add(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
