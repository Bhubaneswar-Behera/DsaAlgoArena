package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * Reference :
 */
public class BinaryTreeMaximumPathSum {
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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Calculate the maximum path sum for the left and right subtrees
        // We use Math.max(0, ...) to ignore negative paths
        int leftMax = Math.max(0, maxSum(node.left));
        int rightMax = Math.max(0, maxSum(node.right));

        // Update the global maximum path sum
        max = Math.max(max, leftMax + rightMax + node.val);

        // Return the maximum path sum including the current node
        return node.val + Math.max(leftMax, rightMax);
    }
}
