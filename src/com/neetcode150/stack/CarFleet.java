package com.neetcode150.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * https://neetcode.io/problems/car-fleet
 */
public class CarFleet {

    public static void main(String[] args) {
        int target = 10;
        int[] position = {4,1,0,7};
        int[] speed = {2,2,1,1};
        System.out.println(carFleet(target, position, speed)); // Output: 3
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Step 1: Create pairs of (position, timeToReach)
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Step 2: Sort cars by position DESCENDING (farthest from destination first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        // Step 3: Iterate through each car
        for (int i = 0; i < n; i++) {
            double currentTime = cars[i][1];
            // If stack is empty or current car takes longer (new fleet)
            if (stack.isEmpty() || currentTime > stack.peek()) {
                stack.push(currentTime);  // new fleet
            }
            // Else: current car joins the fleet ahead (do nothing)
        }

        return stack.size(); // number of fleets
    }
}
