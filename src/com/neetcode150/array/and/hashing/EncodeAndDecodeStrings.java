package com.neetcode150.array.and.hashing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://neetcode.io/problems/string-encode-and-decode
 */
public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        List<String> strs = List.of("hello", "world", "abc#123");
        String encoded = encode(strs);
        System.out.println("Encoded: " + encoded);
        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }

    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        //sample output: "5#hello5#world8#abc#123"
        return encoded.toString();
    }

    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;
            // Move to the position of the #
            while (s.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            String str = s.substring(j + 1, j + 1 + length);
            result.add(str);
            i = j + 1 + length;
        }

        return result;
    }
}
