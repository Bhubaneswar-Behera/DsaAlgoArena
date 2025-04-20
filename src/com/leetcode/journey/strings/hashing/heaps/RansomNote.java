package com.leetcode.journey.strings.hashing.heaps;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aabb";
        String magazine = "aabbbcc";

        System.out.println(canConstruct(ransomNote, magazine)); // Output: true
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
    // Create a frequency map for the magazine
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c) || magazineMap.get(c) == 0) {
                return false; // Not enough characters in the magazine
            }
            magazineMap.put(c, magazineMap.get(c) - 1); // Use one character
        }

        return true; // All characters in ransomNote are satisfied
    }
}
