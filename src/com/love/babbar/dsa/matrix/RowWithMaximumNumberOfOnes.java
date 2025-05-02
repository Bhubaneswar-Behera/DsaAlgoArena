package com.love.babbar.dsa.matrix;

/**
 *
 * https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
 */
public class RowWithMaximumNumberOfOnes {

    public static void main(String[] args) {
        int[][] A = {{0,1,1},
                {0,0,1},
                {0,1,1}};
        System.out.println(solve(A));
    }

    public static int solve(int arr[][]) {
        // code here
        int totalNumberOfRows = arr.length;
        int totalNumberOfColumns = arr[0].length;
        int answer = 0;
        //Start from right top position that is row number 0 and totalNumberOfColumns - 1
        int i = 0;
        int j = totalNumberOfColumns - 1;

        while (i < totalNumberOfRows && j >= 0) {
            if (arr[i][j] == 0){
                i++;//move to the next row that is go down
            } else {//we found 1
                answer = i;//current row is the max number of 1's
                j--;//move one column left
            }
        }

        return answer;

    }
}
