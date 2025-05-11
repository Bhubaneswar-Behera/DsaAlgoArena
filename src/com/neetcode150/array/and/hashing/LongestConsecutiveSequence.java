package com.neetcode150.array.and.hashing;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * https://neetcode.io/problems/longest-consecutive-sequence
 * Reference : https://www.youtube.com/watch?v=LvbtUMdcgbw&t=391s
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums)); // Output: 4
    }

    public static int longestConsecutive(int[] nums) {
        int longestLength = 0;
        Map<Integer, Boolean> numberTravelledMap = new HashMap<>();
        for (int num : nums) {
            numberTravelledMap.put(num, Boolean.FALSE);
        }

        for (int num : nums) {
            int currentLength = 1;

            // Check in forward direction
            int nextNum = num + 1;
            while (numberTravelledMap.containsKey(nextNum) &&
                    numberTravelledMap.get(nextNum) == false) {

                currentLength++;
                numberTravelledMap.put(nextNum, Boolean.TRUE);

                // Move to the next number
                nextNum++;
            }

            // Check in reverse direction
            int prevNum = num - 1;
            while (numberTravelledMap.containsKey(prevNum) &&
                    numberTravelledMap.get(prevNum) == false) {

                currentLength++;
                numberTravelledMap.put(prevNum, Boolean.TRUE);

                // Move to the previous number
                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;
    }
}
