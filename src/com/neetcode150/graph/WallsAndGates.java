package com.neetcode150.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://neetcode.io/practice?tab=neetcode150
 * Reference : https://www.youtube.com/watch?v=c9Myn-zYmJs
 */
public class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };

        WallsAndGates solution = new WallsAndGates();
        solution.wallsAndGates(rooms);

        // Print the updated rooms
        for (int[] row : rooms) {
            for (int room : row) {
                System.out.print(room + " ");
            }
            System.out.println();
        }
    }
    private static final int INF = 2147483647;
    private static final int[] DIRS = {0, 1, 0, -1, 0}; // 4-directional (right, down, left, up)

    public void wallsAndGates(int[][] rooms) {
        // Check if the input is valid
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Add gates to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the room is a gate (0) --> checks if the current cell is a gate
                // then add it to the queue
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS from each gate
        while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int row = gate[0];
            int col = gate[1];

            for (int i = 0; i < 4; i++) { // Explore 4 directions
                int newRow = row + DIRS[i];
                int newCol = col + DIRS[i + 1];

                // Check boundaries and if the cell is an empty room
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == INF) {
                    rooms[newRow][newCol] = rooms[row][col] + 1; // Update distance
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
