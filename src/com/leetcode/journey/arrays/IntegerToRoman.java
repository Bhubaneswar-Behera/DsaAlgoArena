package com.leetcode.journey.arrays;

/**
 * https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println("Roman numeral: " + intToRoman(num));
    }
    public static String intToRoman(int num) {
        // Define Roman numeral symbols and their corresponding values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Iterate through the values and symbols
        for (int i = 0; i < values.length; i++) {
            // Append the symbol while subtracting its value from the number
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
}
