package com.leetcode.journey.strings.hashing.heaps;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class IsomorphicStrings {
    public static void main(String[] args) {

    }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Check if the mapping is consistent
            if (sToTMap.containsKey(sChar) && sToTMap.get(sChar) != tChar) {
                return false;
            }
            if (tToSMap.containsKey(tChar) && tToSMap.get(tChar) != sChar) {
                return false;
            }

            // Add the mapping
            sToTMap.put(sChar, tChar);
            tToSMap.put(tChar, sChar);
        }

        return true;
    }
}
