package com.neetcode150.array.and.hashing;

import java.util.Arrays;

/**
 *
 * https://neetcode.io/practice?tab=neetcode150
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "jar";
        String t = "jam";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        int i = 0;
        int j = sLength - 1;

        while (i <= j){
            if (sArray[i] != tArray[i]) {
                return false;
            }
            i++;
        }
        return true;

    }
}
