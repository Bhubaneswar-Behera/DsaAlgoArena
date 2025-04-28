package com.leetcode.journey.trees;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?envType=study-plan-v2&envId=top-interview-150
 */
public class BinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        BinaryTreeFromInorderAndPostorderTraversal builder = new BinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = builder.buildTree(inorder, postorder);
        // The constructed tree will have root value 3, left child 9, and right subtree 20 -> 15, 7
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Map to store the index of each value in the inorder array for quick lookup
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Helper method to construct the tree
        return buildTreeHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                inorderIndexMap);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
                                     int[] postorder, int postStart, int postEnd,
                                     Map<Integer, Integer> inorderIndexMap) {
        // Base case: if there are no elements to construct the tree
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The last element of postorder is the root
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root in the inorder array
        int rootIndex = inorderIndexMap.get(rootVal);

        // Calculate the size of the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + leftSize - 1,
                inorderIndexMap);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1,
                inorderIndexMap);

        return root;
    }
}
