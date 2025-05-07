package com.love.babbar.dsa.strings;

import java.util.Arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
 */
public class CheckIfStringsAreRotationsOfEachOther {

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";
        System.out.println(areRotations(s1, s2)); // true
    }

    public static boolean areRotations(String s1, String s2) {
        // Your code here
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s1Length != s2Length) {
            return false;
        }
        s1 = s1 + s1;
        return s1.lastIndexOf(s2) >= 0;
    }
}
