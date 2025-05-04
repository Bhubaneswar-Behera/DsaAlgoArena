package com.love.babbar.dsa.arrays;

/**
 *
 * https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 */
public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCountBruteForce(arr));
    }
    public static int inversionCount(int arr[]) {
        // Your Code Here
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            // Count inversions in left half
            count += mergeSort(arr, left, mid);

            // Count inversions in right half
            count += mergeSort(arr, mid + 1, right);

            // Count split inversions during merge
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i]; // Copy the element from the left subarray to the temp array
                k++;             // Move to the next position in the temp array
                i++;             // Move to the next position in the left subarray
            } else {
                temp[k] = arr[j]; // Copy the element from the right subarray to the temp array
                k++;             // Move to the next position in the temp array
                j++;             // Move to the next position in the right subarray
                invCount = invCount + (mid - i + 1); // Count inversions for remaining elements in the left subarray
            }
        }

        // Add remaining elements from left and right subarrays
        while (i <= mid) {
            temp[k] = arr[i]; // Copy the element from the left subarray to the temp array
            k++;             // Move to the next position in the temp array
            i++;             // Move to the next position in the left subarray
        }
        while (j <= right) {
            temp[k] = arr[j]; // Copy the element from the right subarray to the temp array
            k++;             // Move to the next position in the temp array
            j++;             // Move to the next position in the right subarray
        }

        // Copy merged elements back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }

        return invCount;
    }
    public static int inversionCountBruteForce(int arr[]) {
        // Your Code Here
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n ; j++) {
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
