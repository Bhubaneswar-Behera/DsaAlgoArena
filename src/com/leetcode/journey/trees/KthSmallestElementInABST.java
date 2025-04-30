package com.leetcode.journey.trees;

/**
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;
        System.out.println("Kth Smallest Element: " + kthSmallest(root, k)); // Output: 3
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] result = new int[2]; // result[0] = count, result[1] = kth smallest value
        inOrderTraversal(root, k, result);
        return result[1];
    }

    private static void inOrderTraversal(TreeNode node, int k, int[] result) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(node.left, k, result);

        // Increment the counter and check if the current node is the kth smallest
        result[0]++;
        if (result[0] == k) {
            result[1] = node.val;
            return;
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k, result);
    }
}
