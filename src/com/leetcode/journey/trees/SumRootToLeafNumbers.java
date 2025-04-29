package com.leetcode.journey.trees;

/**
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {

    }
    public int sumNumbers(TreeNode root) {
        // Base case: if the root is null, return 0
        if (root == null) {
            return 0;
        }

        // Call a helper method to perform DFS and calculate the sum
        return dfs(root, 0);
    }

    // Helper method for DFS traversal
    private int dfs(TreeNode node, int currentSum) {
        // Base case: if the node is null, return 0
        if (node == null) {
            return 0;
        }

        // Update the current sum by including the current node's value
        currentSum = currentSum * 10 + node.val;

        // If the node is a leaf, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recur for left and right subtrees and return their sum
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
