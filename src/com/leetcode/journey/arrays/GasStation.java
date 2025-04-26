package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("Starting gas station index: " + canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, tank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If tank is negative, reset the starting station and tank
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // Check if the total gas is sufficient to cover the total cost
        return totalGas >= totalCost ? start : -1;
    }
}
