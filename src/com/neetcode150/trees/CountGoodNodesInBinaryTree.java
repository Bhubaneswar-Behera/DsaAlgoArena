package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Reference : https://www.youtube.com/watch?v=XzKoa5G0WnU
 */
public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {

    }
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root,  Integer.MIN_VALUE);
    }
    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        int rootAnswer = 0;
        if (node.val >= maxSoFar) {
            rootAnswer = 1; // This node is a good node
            maxSoFar = node.val; // Update the maximum value seen so far
        }
        // Count good nodes in left and right subtrees
        int leftNodeAnswer = countGoodNodes(node.left,  maxSoFar);
        int rightNodeAnswer = countGoodNodes(node.right,maxSoFar);
        return leftNodeAnswer + rightNodeAnswer + rootAnswer;
    }
}
