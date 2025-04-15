package com.leetcode.journey.strings.hashing.heaps;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        int n = words.length;
        StringBuilder answer = new StringBuilder();

        for (int i = n - 1; i >= 0 ; i--) {
            answer.append(words[i]);
            if(i != 0){
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}
