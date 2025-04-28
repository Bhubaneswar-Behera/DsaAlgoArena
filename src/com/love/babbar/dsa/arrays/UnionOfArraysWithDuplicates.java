package com.love.babbar.dsa.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://www.geeksforgeeks.org/problems/union-of-two-arrays3538/1
 */
public class UnionOfArraysWithDuplicates {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3};
        System.out.println(findUnion(a, b)); // Output: 5
    }

    public static int findUnion(int a[], int b[]) {
       Set<Integer> hasSet = new HashSet<>();
        for (int i : a){
            hasSet.add(i);
        }
        for (int i : b){
            hasSet.add(i);
        }
        return hasSet.size();
    }
}
