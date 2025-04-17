package com.leetcode.journey.strings.hashing.heaps;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class IndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("Index of first occurrence: " + strStr(haystack, needle)); // Output: 0
    }
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // If needle is empty, return 0
        }
        return haystack.indexOf(needle); //
    }
}
