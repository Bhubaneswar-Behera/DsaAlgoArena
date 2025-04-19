package com.leetcode.journey.strings.hashing.heaps;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println("Is " + n + " a happy number? " + isHappy(n)); // Output: true
    }
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }
    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
