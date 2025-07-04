package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class DiameterOfBinaryTree {

    public static int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        // Return the height of the binary tree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Time Complexity: O(n2)
    public static int diameterOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int currentDiameter = leftHeight + rightHeight;
        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);
        // Return the maximum diameter found in the binary tree
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }

    //Time Complexity: O(n)
    public static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameterOptimized(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftInfo = diameterOptimized(root.left);
        TreeInfo rightInfo = diameterOptimized(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int leftDiameter = leftInfo.diameter;
        int rightDiameter = rightInfo.diameter;
        int currentDiameter = leftDiameter + rightDiameter + 1;

        int diameter = Math.max(currentDiameter, Math.max(leftInfo.diameter, rightInfo.diameter));

        return new TreeInfo(height, diameter);
    }
}
