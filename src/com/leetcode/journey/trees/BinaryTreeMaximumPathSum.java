package com.leetcode.journey.trees;

/**
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        int result = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result); // Output: 6
    }

    private int maxSum = Integer.MIN_VALUE; // Global variable to store the maximum path sum

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the maximum path sum for the left and right subtrees
        int leftMax = Math.max(0, dfs(node.left)); // Ignore negative paths
        int rightMax = Math.max(0, dfs(node.right)); // Ignore negative paths

        // Update the global maximum path sum
        maxSum = Math.max(maxSum, leftMax + rightMax + node.val);

        // Return the maximum path sum including the current node
        return node.val + Math.max(leftMax, rightMax);
    }
}
