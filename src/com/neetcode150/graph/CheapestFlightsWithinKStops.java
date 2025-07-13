package com.neetcode150.graph;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 */
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();
        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costs = new int[n];
        // Initialize costs to maximum value
        Arrays.fill(costs, Integer.MAX_VALUE);
        // The cost to reach the source node is 0
        costs[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = costs.clone(); // Clone the costs array to use for this iteration
            for (int[] flight : flights) {
                int source = flight[0];
                int destination = flight[1];
                int cost = flight[2];
                // If the source node is not reachable, skip it
                if (costs[source] == Integer.MAX_VALUE) {
                    continue;
                }
                // Update the cost to reach the destination node
                if (temp[destination] > costs[source] + cost) {
                    temp[destination] = costs[source] + cost;
                }
            }
            costs = temp;
        }

        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}
