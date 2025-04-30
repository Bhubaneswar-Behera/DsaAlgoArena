package com.love.babbar.dsa.arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
 */
public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }
    public static int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        // If array has only one element,  already at the end
        if (n <= 1) return 0;

        // If the first element is 0,  can't move anywhere
        if (arr[0] == 0) return -1;

        //Tracks the number of jumps made.
        int jumps = 0;

        // Tracks the current end of the jump range
        int currentEnd = 0;

        // Tracks the farthest index reachable from the current position
        int farthest = 0;

        // Traverse the array up to the second last element
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest index reachable
            //This ensures that we always know
            // the farthest point we can reach from the current range of jumps.
            farthest = Math.max(farthest, i + arr[i]);

            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If the current end reaches or exceeds the last index
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }

        // If we cannot reach the end
        return -1;

    }
}
