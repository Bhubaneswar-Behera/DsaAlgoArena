package com.neetcode150.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://neetcode.io/problems/minimum-window-with-characters
 * Reference : https://www.youtube.com/watch?v=tMx5JZSBWIE
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // Output: "BANC"
        // Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    }

   public static String minWindow(String s, String t) {
       if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
           return "";
       }

       // Create a frequency map for characters in t
       Map<Character, Integer> mapT = new HashMap<>();
       // Populate the frequency map with characters from t
       for(int i=0; i< t.length(); i++){
           mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0) + 1);
       }

       int required = mapT.size();
       int left = 0;
       int right = 0;
       int create = 0;
         // This will store the length of the minimum window substring
       int [] ans = {-1, 0, 0};
       Map<Character, Integer> subStringMap = new HashMap<>();

       while(right < s.length()){
           char currentChar = s.charAt(right);
           // Add the current character to the substring map
           subStringMap.put(currentChar, subStringMap.getOrDefault(currentChar, 0) + 1);
              // If the current character's frequency matches the frequency in t, increment create
           if(mapT.containsKey(currentChar) && subStringMap.get(currentChar).intValue() == mapT.get(currentChar).intValue()){
               create++;
           }
              // If we have a valid window (all characters in t are present in the substring)
           while(left <= right && required == create){
               currentChar = s.charAt(left);
               if(ans[0] == -1 || ans[0] >= right - left + 1){
                   ans[0] = right - left + 1;
                   ans[1] = left;
                   ans[2] = right;
               }

                // Remove the leftmost character from the substring map
               subStringMap.put(currentChar,subStringMap.get(currentChar) - 1);
                // If the frequency of the leftmost character is less than the frequency in t, decrement create
               if(mapT.containsKey(currentChar) && subStringMap.get(currentChar).intValue() < mapT.get(currentChar).intValue()){
                   create--;
               }
               left++;
           }
           right++;
       }


       if(ans[0] == -1){
           return "";
       }
       else{
           return s.substring(ans[1], ans[2] + 1);
       }
    }
}
