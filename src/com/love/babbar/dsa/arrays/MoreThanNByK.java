package com.love.babbar.dsa.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
 */
public class MoreThanNByK {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 2, 1, 2, 3, 3};
        int k = 4;
        moreThanNbyK(arr, k);
    }

    public static void moreThanNbyK(int[] arr, int k) {
        int n = arr.length;
        int x = n / k;

        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > x) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
