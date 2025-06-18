package com.neetcode150.trees;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Reference : https://www.youtube.com/watch?v=PbPS460rbMo
 */
public class ConstructBinaryTreeFromPreorderAndInorder {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        // Create a map to store the index of each value in inOrder array
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }

        return splitTree(preOrder, inOrderIndexMap,
                0, 0, inOrder.length - 1);
    }
    // This function recursively splits the tree based on the preOrder and inOrder arrays
    private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
                               int rootIndex, int left, int right) {

        // A new TreeNode is created using the value at the current
        // rootIndex in the preOrder array.
        TreeNode root = new TreeNode(preOrder[rootIndex]);

        // Create left and right subtree
        //The index of the current root value
        // in the inOrder array is retrieved from the inOrderIndexMap.
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);
        // If mid is equal to left, it means there is no left subtree.
        if (mid > left) {
            root.left = splitTree(preOrder, inOrderIndexMap,
                    rootIndex + 1, left, mid - 1);
        }
        // If mid is less than right, it means there is no right subtree.
        if (mid < right) {
            //mid - left gives the number of nodes in the left subtree.
            // Adding 1 moves the index to the start of the right subtree in the preOrder array.
            root.right = splitTree(preOrder, inOrderIndexMap,
                    rootIndex + mid - left + 1, mid + 1, right);
        }
        return root;
    }
}
