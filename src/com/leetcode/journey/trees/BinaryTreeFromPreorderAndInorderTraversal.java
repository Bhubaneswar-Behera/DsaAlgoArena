package com.leetcode.journey.trees;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        BinaryTreeFromPreorderAndInorderTraversal builder = new BinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = builder.buildTree(preorder, inorder);
        // The constructed tree will have root value 3, left child 9, and right subtree 20 -> 15, 7
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to store the index of each value in the inorder array for quick lookup
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Helper method to construct the tree
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd,
                                     Map<Integer, Integer> inorderIndexMap) {
        // Base case: if there are no elements to construct the tree
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element of preorder is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root in the inorder array
        int rootIndex = inorderIndexMap.get(rootVal);

        // Calculate the size of the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1, inorderIndexMap);
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd, inorderIndexMap);

        return root;
    }
}
