package com.leetcode.journey.arrays;

/**
 * Given arr[n] , return the length of the smallest
 * subarray which contains both the minimum and maximum of the array.
 *
 * Example :
 * Input : A[] = {2, 2, 6, 4, 5, 2, 6, 4, 1} Output : 3
 * Explanation :
 * min is 1 ,max is 6 --> smallest subarray is [6,4,1]  --> length is 3
 *
 */
public class SmallestSubArrayMinAndMax {
    public static void main(String[] args) {
        int[] arr = {2, 2, 6, 4, 5, 2, 6, 4, 1};
        System.out.println(smallestSubArray(arr));
    }
    public static int smallestSubArray(int[] arr){
        int n = arr.length;
        int answer = Integer.MAX_VALUE;
        int maxNumber = getMax(arr);
        int minNumber = getMin(arr);
        int lastMinIndex = -1;
        int lastMaxIndex = -1;

        for (int i = 0; i < n ; i++) {
            if (arr[i] == minNumber) {
                lastMinIndex = i;
                if(lastMinIndex != -1){
                    answer =Math.min(answer,i- lastMinIndex+1);
                }
            }
            if (arr[i] == maxNumber) {
                lastMaxIndex = i;
                if (lastMaxIndex != -1){
                    answer = Math.min(answer, i - lastMaxIndex + 1);
                }
            }
        }

        return answer;
    }
    public static int getMax(int[] arr){
        int n = arr.length;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n ; i++) {
            answer = Math.max(answer, arr[i]);
        }
        return answer;
    }

    public static int getMin(int[] arr){
        int n = arr.length;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n ; i++) {
            answer = Math.min(answer, arr[i]);
        }
        return answer;
    }
}
