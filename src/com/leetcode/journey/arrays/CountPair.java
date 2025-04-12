package com.leetcode.journey.arrays;

/**
 * Given a string of lower case characters, return the number of pairs of indices (i, j) such that
 * i < j and s[i] == a & s[j]= g.
 *
 */
public class CountPair {
     public static void main(String[] args) {
        String str = "abegag";
        System.out.println("BruteForce approach :"+ countPairsBruteForce(str));
         System.out.println("Carry forward approach :"+ countPairsCarryForward(str));
    }
    public static int countPairsBruteForce(String str){
         int n = str.length();
         int answer = 0;
        for (int i = 0; i < n ; i++) {
            if(str.charAt(i) == 'a'){
                for (int j = i+1; j < n  ; j++) {
                        if (str.charAt(j) == 'g') {
                            answer++;
                        }
                }
            }
        }
         return answer;
    }

    public static int countPairsCarryForward(String str){
         int n = str.length();
         int answer = 0;
         int countOfA = 0;

        for (int i = 0; i < n ; i++) {
            if(str.charAt(i) == 'a') {
                countOfA++;
            } else if(str.charAt(i) == 'g' ){
                answer = answer + countOfA;
            }
        }
         return answer;
    }
}
