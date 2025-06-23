package com.neetcode150.heap.priority.queue;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 * Reference : https://www.youtube.com/watch?v=RLyF_-4Izg0
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        // Example usage
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] result = solution.kClosest(points, k);

        // Print the result
        for (int[] point : result) {
            System.out.println(point[0] + ", " + point[1]);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        // Create a max-heap based on the distance from the origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        // Add points to the heap, and remove the farthest point if heap size exceeds k
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Collect the k closest points from the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
