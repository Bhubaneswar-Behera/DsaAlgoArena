package com.neetcode150.trees;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * Reference : https://www.youtube.com/watch?v=sLoZJ2E4ZDs
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        boolean result = solution.isValidBST(root);
        System.out.println("Is valid BST: " + result); // Output: true
    }
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    // Checks whether a binary tree is a valid Binary Search Tree (BST)
    public boolean isValidBST(TreeNode root) {

        // Stores inorder traversal of the tree
        // In a valid BST, inorder traversal should be strictly increasing
        List<Integer> inOrderList = new LinkedList<>();

        // Populate the inorder traversal list
        helper(root, inOrderList);

        // Assume tree is BST initially
        boolean isBST = true;

        // Store first element as previous value
        int prev = inOrderList.get(0);

        // Traverse remaining elements in inorder list
        for (int i = 1; i < inOrderList.size(); i++) {

            // In BST:
            // Current value must always be greater than previous value
            // If smaller OR duplicate found -> not a valid BST
            if (inOrderList.get(i) <= prev) {
                isBST = false;
            }

            // Update previous element
            prev = inOrderList.get(i);
        }

        // Return final BST validation result
        return isBST;
    }

    void helper(TreeNode treeNode, List<Integer> inOrderList) {
        if (treeNode == null) {
            return;
        }

        helper(treeNode.left, inOrderList);
        inOrderList.add(treeNode.val);
        helper(treeNode.right, inOrderList);
    }
}
