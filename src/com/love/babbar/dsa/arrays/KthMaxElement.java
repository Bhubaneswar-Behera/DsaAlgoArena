package com.love.babbar.dsa.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthMaxElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthMax(arr, k));
    }
    //without using any sorting algorithm
    public static int kthMax(int[] arr, int k){
        int n = arr.length;
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n ; i++) {
            pq.add(arr[i]);
        }

        for (int i = 0; i < k ; i++) {
            answer = pq.poll();

        }

        return answer;
    }
}
