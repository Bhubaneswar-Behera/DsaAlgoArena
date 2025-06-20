package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the left and right children
        root.left = right;
        root.right = left;

        return root;
    }
}
