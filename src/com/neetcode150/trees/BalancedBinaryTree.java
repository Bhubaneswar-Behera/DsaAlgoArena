package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * For every node:
 *    | height(left subtree) - height(right subtree) | ≤ 1
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);// Calculate height of left subtree
        if (left == -1) {// If left subtree is not balanced
            return -1;
        }

        int right = height(node.right);// Calculate height of right subtree
        if (right == -1) {// If right subtree is not balanced
            return -1;
        }

        if (Math.abs(left - right) > 1) {// Check balance condition
            return -1;
        }
        // If the tree is balanced,
        // return the height of the node
        return Math.max(left, right) + 1;
    }
}
