package com.neetcode150.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/next-greater-element-i/description/
 * Reference : https://www.youtube.com/watch?v=mJWQjJpEMa4
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                // Pop the top of the stack and map it to the current number
                nextGreater.put(stack.pop(), num);
            }
            // Push the current number onto the stack
            stack.push(num);
        }

        // For any remaining elements in the stack, there is no next greater element
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // If the number is not found in the map, it means there is no next greater element
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
