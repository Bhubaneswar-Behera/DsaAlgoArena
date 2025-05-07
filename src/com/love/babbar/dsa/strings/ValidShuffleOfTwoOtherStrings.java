package com.love.babbar.dsa.strings;

import java.util.Arrays;

/**
 *
 * https://www.programiz.com/java-programming/examples/check-valid-shuffle-of-strings
 */
public class ValidShuffleOfTwoOtherStrings {

    public static void main(String[] args) {
        String str1 = "XY";
        String str2 = "12";
        String str3 = "1XY2";

        if (isValidShuffle(str1, str2, str3)) {
            System.out.println("Valid shuffle");
        } else {
            System.out.println("Invalid shuffle");
        }
    }
    public static boolean isValidShuffle(String str1, String str2, String str3) {
        // Check if the length of str3 is equal to the sum of lengths of str1 and str2
        if (str3.length() != str1.length() + str2.length()) {
            return false;
        }

        // Create a character array to store the characters of str3
        char[] charArray = new char[str3.length()];
        for (int i = 0; i < str3.length(); i++) {
            charArray[i] = str3.charAt(i);
        }

        // Sort the character array
        Arrays.sort(charArray);

        // Create a string from the sorted character array
        String sortedStr3 = new String(charArray);

        // Concatenate str1 and str2 and sort the result
        String combinedStr = str1 + str2;
        char[] combinedCharArray = combinedStr.toCharArray();
        Arrays.sort(combinedCharArray);
        String sortedCombinedStr = new String(combinedCharArray);

        // Compare the sorted strings
        return sortedStr3.equals(sortedCombinedStr);
    }
}
