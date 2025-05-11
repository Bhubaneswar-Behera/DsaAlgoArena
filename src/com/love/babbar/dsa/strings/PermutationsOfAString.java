package com.love.babbar.dsa.strings;

import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
 */
public class PermutationsOfAString {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(findPermutation(s));
    }
    public static ArrayList<String> findPermutation(String s) {
        Set<String> result = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for (char ch : s.toCharArray()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                for (int i = 0; i <= current.length(); i++) {
                    String newPermutation = current.substring(0, i) + ch + current.substring(i);
                    queue.add(newPermutation);
                }
            }
        }

        // move unique values to list
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return new ArrayList<>(result);
    }
}
