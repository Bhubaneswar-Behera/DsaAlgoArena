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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();

        // Populate the list
        helper(root, inOrderList);

        boolean isBST = true;
        int prev = inOrderList.get(0);// Initialize previous element with the first element of inOrderList
        for (int i = 1; i < inOrderList.size(); i++) {

            // Check if new element is smaller than previous element
            // or if the element is duplicate
            if (inOrderList.get(i) <= prev) {
                isBST = false;
            }

            prev = inOrderList.get(i);//keep updating the previous element
        }

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
