package com.leetcode.journey.maths.and.bit.manipulation;

/**
 *
 * https://leetcode.com/problems/add-binary/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int sum = bitA + bitB + carry;
            result.append(sum % 2); // Append the current bit
            carry = sum / 2; // Update the carry

            i--;
            j--;
        }

        return result.reverse().toString();
    }
}
