package com.leetcode.journey.maths.and.bit.manipulation;

public class ToggleBit {
    public static void main(String[] args) {
        int A = 5;
        int B = 2;

        System.out.println(toggle(A,B));
    }
    public static int toggle(int A, int B){
        return A ^ (1 << B);
    }
}
