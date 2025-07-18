package com.neetcode150.heap.priority.queue;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/task-scheduler/description/
 * Reference : https://www.youtube.com/watch?v=c9Myn-zYmJs
 */
public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n)); // Output: 8
    }
    public static int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Step 2: Build a max heap based on the frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());

        // Step 3: Process tasks
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            for (int freq : temp) {
                if (--freq > 0) {
                    maxHeap.add(freq);
                }
            }

            // Step 4: Update time
            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return time;
    }
}
