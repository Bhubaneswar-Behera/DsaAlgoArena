package com.love.babbar.dsa.strings;

/**
 *
 * https://leetcode.com/problems/count-and-say/description/
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
       String s = "1";
        for (int i = 1; i < n ; i++) {
            s = countAndSayHelper(s);
        }
        return s;
    }
    public static String countAndSayHelper(String s){
        StringBuilder sb = new StringBuilder();
        char previousChar = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == previousChar) {
                count++;
            } else {
                sb.append(count);
                sb.append(previousChar);
                previousChar = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(previousChar);
        return sb.toString();
    }
}
