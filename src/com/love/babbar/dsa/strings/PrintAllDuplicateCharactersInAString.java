package com.love.babbar.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
 */

public class PrintAllDuplicateCharactersInAString {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        printDuplicateCharacters(str);
    }
    public static void printDuplicateCharacters(String str){
        int n = str.length();
        char[] chars = str.toCharArray();
        HashMap<Object, Object> charCountMap = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            if (charCountMap.containsKey(str.charAt(i))) {
                charCountMap.put(str.charAt(i), (int) charCountMap.get(str.charAt(i)) + 1);
            } else {
                charCountMap.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry<Object, Object> entry : charCountMap.entrySet()) {
            if ((int) entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
