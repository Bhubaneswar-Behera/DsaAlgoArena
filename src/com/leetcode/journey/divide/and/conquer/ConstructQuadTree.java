package com.leetcode.journey.divide.and.conquer;

/**
 *
 * https://leetcode.com/problems/construct-quad-tree/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ConstructQuadTree {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1},
                {1, 0}
        };

        ConstructQuadTree quadTree = new ConstructQuadTree();
        Node root = quadTree.construct(grid);

        // Output the Quad-Tree structure (serialization can be implemented if needed)
        System.out.println(root);
    }

    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {
        // Check if the grid is uniform (all 0's or all 1's)
        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        // Divide the grid into four quadrants
        int newSize = size / 2;
        Node topLeft = build(grid, row, col, newSize);
        Node topRight = build(grid, row, col + newSize, newSize);
        Node bottomLeft = build(grid, row + newSize, col, newSize);
        Node bottomRight = build(grid, row + newSize, col + newSize, newSize);

        // Create a parent node
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int value = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
