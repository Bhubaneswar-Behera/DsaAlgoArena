package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class DiameterOfBinaryTree {

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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // Update the diameter at this node
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return the height of this node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
