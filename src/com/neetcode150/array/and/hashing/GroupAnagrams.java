package com.neetcode150.array.and.hashing;


import java.util.*;

/**
 *
 * https://neetcode.io/problems/anagram-groups
 */

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort the string to create a key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Check if the key exists, if not, initialize a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            // Add the string to the corresponding group
            map.get(key).add(str);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}
