package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = removeDuplicates(nums);
        System.out.println("k = " + k); // Output: 5
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " "); // Output: 1 1 2 2 3
        }
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length; // If the array has 2 or fewer elements, no duplicates need to be removed
        }

        int index = 2; // Start from the third position
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) { // Check if the current element is different from the element at index - 2
                nums[index] = nums[i]; // Place the current element at the index position
                index++; // Increment the index
            }
        }

        return index; // Return the length of the modified array
    }
}
