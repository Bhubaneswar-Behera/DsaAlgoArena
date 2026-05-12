package com.neetcode150.binary.search;

/**
 *
 * https://neetcode.io/problems/eating-bananas
 * Reference: https://www.youtube.com/watch?v=JGYXNpZaW2U
 */
/**
 * Finds the minimum eating speed required to finish all banana piles
 * within the given number of hours.
 *
 * Approach:
 * - Use Binary Search on possible eating speeds.
 * - Minimum possible speed = 1 banana/hour.
 * - Maximum possible speed = largest pile size.
 *
 * Time Complexity:
 * O(n * log(maxPile))
 *
 * Space Complexity:
 * O(1)
 *
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {1,4,3,2};
        int hours = 9;
        System.out.println(minEatingSpeed(piles, hours));
    }
    public static int minEatingSpeed(int[] piles, int hours) {
        // Minimum possible eating speed
        int minimumSpeed = 1;

        // Maximum possible eating speed
        int maximumSpeed = 0;

        // Find the largest pile size
        for (int pileSize : piles) {
            maximumSpeed = Math.max(maximumSpeed, pileSize);
        }

        // Perform Binary Search on eating speed
        while (minimumSpeed < maximumSpeed) {

            int currentSpeed = minimumSpeed + (maximumSpeed - minimumSpeed) / 2;

            // Check whether Koko can finish all piles
            // within the allowed hours at current speed
            if (canEatInTime(piles, hours, currentSpeed)) {
                // Try smaller speed
                maximumSpeed = currentSpeed;

            } else {
                // Increase speed because current speed is too slow
                minimumSpeed = currentSpeed + 1;
            }
        }

        return minimumSpeed;
    }

    /**
     * Checks whether Koko can finish all banana piles
     * within the given hours using the provided speed.
     *
     * Formula:
     * Required Hours =
     * ceil(pileSize / speed)
     *
     * Example:
     * pile = 10, speed = 3
     * required hours = 4
     *
     * @param piles banana pile array
     * @param inputHours allowed hours
     * @param speed bananas eaten per hour
     * @return true if all piles can be finished in time
     */
    private static boolean canEatInTime(int[] piles, int inputHours, int speed) {
        int totalHoursRequired = 0;

        for (int pileSize : piles) {

            // Ceiling division to calculate hours required
            totalHoursRequired += (int) Math.ceil((double) pileSize / speed);
        }

        return totalHoursRequired <= inputHours;
    }
    }


