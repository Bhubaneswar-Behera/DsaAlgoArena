package com.love.babbar.dsa.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
 */
public class FactorialsOfLargeNumbers {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> result = factorial(n);
        System.out.println("Digits of " + n + "! are: " + result);
    }
    public static ArrayList<Integer> factorial(int n) {
        // code here
        BigInteger fact = BigInteger.ONE;

        // Calculate factorial using BigInteger
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        ArrayList<Integer> digits = new ArrayList<>();
        // Convert BigInteger to string and then to list of digits
        String str= fact.toString();
        int len = str.length();
        for(int i=0; i<len; i++){
            digits.add(str.charAt(i)-'0');
        }
        return digits;
    }
}
