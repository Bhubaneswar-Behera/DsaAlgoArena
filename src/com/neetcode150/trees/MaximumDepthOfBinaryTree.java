package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \
            4   5

            Max Depth = 3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int depth = maxDepth(root);

        System.out.println("Maximum Depth of Tree: " + depth);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
