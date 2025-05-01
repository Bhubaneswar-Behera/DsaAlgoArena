package com.love.babbar.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *https://www.youtube.com/watch?v=LvbtUMdcgbw
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(longestConsecutive(arr)); // Output: 6
    }

    // Function to return length of longest subsequence of consecutive integers.
    public static int longestConsecutive(int[] arr) {
        // code here
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : arr) {
            // Check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;

    }
}
