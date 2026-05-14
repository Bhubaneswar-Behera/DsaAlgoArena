package com.neetcode150.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementInABST {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementInABST solution = new KthSmallestElementInABST();
        int k = 1; // Find the 1st smallest element
        System.out.println(solution.kthSmallest(root, k)); // Output: 1
    }
    // Returns the kth smallest element in a Binary Search Tree (BST)
    public int kthSmallest(TreeNode root, int k) {

        // Stores inorder traversal of BST
        // Inorder traversal of BST gives elements in sorted order
        List<Integer> inorder = new ArrayList<>();

        // Populate inorder list
        inOrderTraversal(root, inorder);

        // kth smallest element will be present at index (k - 1)
        return inorder.get(k - 1);
    }

    // Performs inorder traversal of the binary tree
    private void inOrderTraversal(TreeNode node, List<Integer> inorder) {

        // Base condition
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inOrderTraversal(node.left, inorder);

        // Visit current node
        inorder.add(node.val);

        // Traverse right subtree
        inOrderTraversal(node.right, inorder);
    }
}
