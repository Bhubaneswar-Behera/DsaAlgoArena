package com.leetcode.journey.arrays;

import java.util.Arrays;

/**
 * Given Array[n] , where each element is 0.
 * Return final array after performing multiple queries.
 *
 * query(i,x) --> Add x to all number of array starting from i to n-1.
 * Note : Using PrefixSum
 */
public class SubQueryAddition {
    public static void main(String[] args) {
        int n = 7;
        int[] array = new int[n];
        int[][] queries = {{1,3},{4,-2},{3,1}};
        System.out.println(Arrays.toString(solution(array,queries)));
    }
    public static int[] solution(int[] arr,int[][] queries){
        int n = arr.length;;
        int q = queries.length;

        for (int i = 0; i < q; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            arr[index] = arr[index] + value;
        }
        for (int i = 1; i < n ; i++) {
        arr[i] = arr[i] + arr[i-1];
        }

        return arr;
    }
}
