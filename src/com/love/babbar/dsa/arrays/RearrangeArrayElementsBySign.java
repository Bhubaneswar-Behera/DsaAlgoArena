package com.love.babbar.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 */
public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4}; //output : [1, -4, 2, -1, 3, 4]
        ArrayList<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        rearrange(list);
        //System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(ArrayList<Integer> arr) {
        List<Integer> positiveIntegerList = new ArrayList<>();
        List<Integer> negativeIntegerList = new ArrayList<>();

        // Separate positive and negative numbers
        for (int num : arr) {
            if (num >= 0) {
                positiveIntegerList.add(num);
            } else {
                negativeIntegerList.add(num);
            }
        }

        // Merge positive and negative numbers alternately
        int i = 0, j = 0, k = 0;
        while (i < positiveIntegerList.size() && j < negativeIntegerList.size()) {
            arr.set(k, positiveIntegerList.get(i));
            k++;
            i++;
            arr.set(k, negativeIntegerList.get(j));
            k++;
            j++;
        }

        // Append remaining positive numbers
        while (i < positiveIntegerList.size()) {
            arr.set(k, positiveIntegerList.get(i));
            k++;
            i++;
        }

        // Append remaining negative numbers
        while (j < negativeIntegerList.size()) {
            arr.set(k, negativeIntegerList.get(j));
            k++;
            j++;
        }

        System.out.println(arr);
    }

}
