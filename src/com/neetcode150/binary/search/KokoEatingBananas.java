package com.neetcode150.binary.search;

/**
 *
 * https://neetcode.io/problems/eating-bananas
 * Reference: https://www.youtube.com/watch?v=JGYXNpZaW2U
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {1,4,3,2};
        int h = 9;
        System.out.println(minEatingSpeed(piles, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;

        // Find max pile size
        int maxSpeed = 0;
        for (int pile : piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }

        // Binary search
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canEatInTime(piles, h, mid)) {
                maxSpeed = mid;
            }
            else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }
    private static boolean canEatInTime(int[] piles, int h, int speed) {
        int hours = 0;
        for(int pile : piles) {
            hours = hours + (int) Math.ceil((double) pile / speed);
        }

        return hours <= h;
    }

}
