package com.love.babbar.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://www.geeksforgeeks.org/problems/common-elements1132/1
 */
public class CommonIn3SortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};

        List<Integer> list1 = Arrays.stream(arr1).boxed().toList();
        List<Integer> list2 = Arrays.stream(arr2).boxed().toList();
        List<Integer> list3 = Arrays.stream(arr3).boxed().toList();

        CommonIn3SortedArrays obj = new CommonIn3SortedArrays();
        List<Integer> result = obj.commonElements(list1, list2, list3);
        System.out.println(result);
    }

    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        int arr1Size = arr1.size();
        int arr2Size = arr2.size();
        int arr3Size = arr3.size();
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1Size && j < arr2Size && k < arr3Size){
            if(arr1.get(i).equals(arr2.get(j)) && arr2.get(j).equals(arr3.get(k))){
                // handle duplicates properly when comparing elements across the three arrays.
                if (result.isEmpty() || !result.get(result.size() - 1).equals(arr1.get(i))) {
                    result.add(arr1.get(i));
                }
                i++;
                j++;
                k++;
            } else if(arr1.get(i) < arr2.get(j)){
                i++;
            } else if(arr2.get(j) < arr3.get(k)){
                j++;
            } else{
                k++;
            }
        }


        return result.isEmpty() ? List.of(-1) : result;
    }
}
