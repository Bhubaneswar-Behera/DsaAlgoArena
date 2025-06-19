package com.neetcode150.trees;

public class HeightOfTree {

    public static void main(String[] args) {

    }
    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        // Return the height of the binary tree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
