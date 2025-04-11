package com.leetcode.journey.arrays;

/**
 * Given an Array of size n, count the number of special indices in the array.
 *
 * Special Index --> A index after removing which , the sum of all
 * even indexed elements is equal to sum of all odd indexed elements.
 *
 * Input : A {4, 3, 2, 7, 6, -2}
 * i      A-A[i]          Sum Of Even          Sum Of Odd        Special Index
 * 0     {3,2,7,6,-2}     3 + 7 + (-2) = 8      2 + 6 = 8          True
 * 1     {4,2,7,6,-2}     4 + 7 + (-2) = 9      2 + 6 = 8          False
 * 2     {4,3,7,6,-2}     4 + 7 + (-2) = 9      3 + 6 = 9          True
 *
 */
public class SpecialIndices {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 6, -2};
        System.out.println("Special Indices Count: " + solve(arr));
    }
    public static int solve(int[] arr){
        int n = arr.length;
        int count = 0;
        int[] prefixEvenIndexSum = new int[n];
        int[] prefixOddIndexSum = new int[n];
        prefixEvenIndexSum[0] = arr[0];
        prefixOddIndexSum[0] = 0;

        for(int i = 1;i< n;i++){
            if(i % 2 == 0){
                prefixEvenIndexSum[i] = prefixEvenIndexSum[i-1]+arr[i];
                prefixOddIndexSum[i] = prefixOddIndexSum[i-1];
            } else {
                prefixOddIndexSum[i] = prefixOddIndexSum[i-1]+arr[i];
                prefixEvenIndexSum[i] = prefixEvenIndexSum[i-1];
            }
        }

        for (int i=0;i< n;i++) {
            int evenIndexSum = 0;
            int oddIndexSum = 0;

            if(i == 0){
                evenIndexSum = 0;
                oddIndexSum = 0;
            } else {
                evenIndexSum = prefixEvenIndexSum[i -1] + prefixOddIndexSum[n-1] - prefixOddIndexSum[i];
                oddIndexSum = prefixOddIndexSum[i -1] + prefixEvenIndexSum[n -1] - prefixEvenIndexSum[i];
            }
            if (evenIndexSum == oddIndexSum) {
                count++;
            }
        }
        return count;
    }
}
