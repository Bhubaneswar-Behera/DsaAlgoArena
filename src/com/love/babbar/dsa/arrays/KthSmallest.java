package com.love.babbar.dsa.arrays;

import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
    }
    //without using any sorting algorithm
    public static int kthSmallest(int[] arr, int k) {
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0;i < arr.length;i++){
            pq.add(arr[i]);
        }
        for(int i = 0; i< k ;i++){
            answer = pq.poll();
        }
        return answer;
    }
}
