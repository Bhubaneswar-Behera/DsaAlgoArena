package com.leetcode.journey.trees;

/**
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
        solution.flatten(root);
        printFlattenedTree(root);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // Store the right subtree
        TreeNode tempRight = root.right;

        // Move the left subtree to the right
        root.right = root.left;
        root.left = null;

        // Attach the previously stored right subtree to the end of the current right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = tempRight;
    }

    private static void printFlattenedTree(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }
}
