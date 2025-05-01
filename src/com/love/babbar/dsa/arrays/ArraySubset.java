package com.love.babbar.dsa.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 *
 * https://www.geeksforgeeks.org/problems/array-subset-of-another-array2317/1
 */
public class ArraySubset {
    public static void main(String[] args) {
       int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
       int[] b = {11, 3, 7, 1, 7};
        System.out.println(isSubset(a,b));
    }
    public static boolean isSubset(int a[], int b[]) {
        // Your code here
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            if (!frequencyMap.containsKey(num) || frequencyMap.get(num) == 0) {
                return false; // If any element is missing or insufficient, return false
            }
            frequencyMap.put(num, frequencyMap.get(num) - 1); // Decrease the count
        }
    return true;
    }
}
