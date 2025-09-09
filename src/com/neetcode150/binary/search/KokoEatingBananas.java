package com.neetcode150.binary.search;

/**
 *
 * https://neetcode.io/problems/eating-bananas
 * Reference: https://www.youtube.com/watch?v=JGYXNpZaW2U
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {1,4,3,2};
        int hours = 9;
        System.out.println(minEatingSpeed(piles, hours));
    }
    public static int minEatingSpeed(int[] piles, int hours) {
        int low = 1;

        // Find max pile size
        int high = 0;
        for (int pile : piles){
            high = Math.max(high, pile);
        }

        // Binary search
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canEatInTime(piles, hours, mid)) {
                high = mid; // try smaller speed
            }
            else {
                low = mid + 1; // need bigger speed
            }
        }
        return low;
    }

    /**
     *
     * If Koko eats at speed bananas per hour, can she finish all piles within h hours?
     *
     */
    private static boolean canEatInTime(int[] piles, int inputHours, int speed) {
        int hours = 0;
        for(int pile : piles) {
            hours = hours + (int) Math.ceil((double) pile / speed);
        }

        return hours <= inputHours;
    }

}
