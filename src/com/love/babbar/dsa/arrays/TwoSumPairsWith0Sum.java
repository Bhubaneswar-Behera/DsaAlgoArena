package com.love.babbar.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 * https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 */
public class TwoSumPairsWith0Sum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> result = getPairs(arr);
        for (ArrayList<Integer> pair : result) {
            System.out.println(pair);
        }
    }

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr){
        int n = arr.length;
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                answer.add(pair);
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--;
                }
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return answer;

    }

    public static ArrayList<ArrayList<Integer>> getPairsBruteForce(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        HashSet<String> seenPairs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == 0) {
                    int first = Math.min(arr[i], arr[j]);
                    int second = Math.max(arr[i], arr[j]);
                    String pairKey = first + "," + second;
                    if(!seenPairs.contains(pairKey)){
                        ArrayList<Integer> pair = new ArrayList<>();
                        pair.add(arr[i]);
                        pair.add(arr[j]);
                        answer.add(pair);
                        seenPairs.add(pairKey);
                    }
                }
            }
        }
        return answer;
    }
}
