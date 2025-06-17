package com.neetcode150.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementInABST {

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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inOrderTraversal(root, inorder);
        return inorder.get(k - 1);
    }
    private void inOrderTraversal(TreeNode node, List<Integer> inorder) {
        if (node == null){
            return;
        }

        inOrderTraversal(node.left, inorder);
        inorder.add(node.val);
        inOrderTraversal(node.right, inorder);
    }
}
