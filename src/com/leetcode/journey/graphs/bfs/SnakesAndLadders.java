package com.leetcode.journey.graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/snakes-and-ladders/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SnakesAndLadders {

    public static void main(String[] args) {
        SnakesAndLadders solution = new SnakesAndLadders();
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(solution.snakesAndLadders(board)); // Output: 4
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flattenedBoard = flattenBoard(board, n);

        // BFS setup
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1); // Start at square 1
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) {
                    return moves; // Reached the last square
                }

                // Explore next 6 possible moves
                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int destination = flattenedBoard[next] == -1 ? next : flattenedBoard[next];
                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            moves++;
        }

        return -1; // If the last square is not reachable
    }

    private int[] flattenBoard(int[][] board, int n) {
        int[] flattened = new int[n * n + 1];
        int index = 1;
        boolean leftToRight = true;

        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < n; col++) {
                    flattened[index++] = board[row][col];
                }
            } else {
                for (int col = n - 1; col >= 0; col--) {
                    flattened[index++] = board[row][col];
                }
            }
            leftToRight = !leftToRight;
        }

        return flattened;
    }
}
