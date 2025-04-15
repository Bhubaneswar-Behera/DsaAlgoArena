package com.leetcode.journey.strings.hashing.heaps;

/**
 * https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        int answer = 0;

        for (int i = n - 1; i >= 0 ; i--) {
            if(s.charAt(i) == ' '){
                break;
            }
            answer++;
        }
        return answer;
    }
}
