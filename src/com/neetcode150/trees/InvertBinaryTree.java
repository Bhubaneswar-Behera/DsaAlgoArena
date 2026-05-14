package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        /*
                 4
               /   \
              2     7
             / \   / \
            1   3 6   9
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Before Invert:");
        inorder(root);

        invertTree(root);

        System.out.println("\nAfter Invert:");
        inorder(root);
    }

    public static TreeNode invertTree(TreeNode root) {
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

    // Inorder Traversal
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
