package com.neetcode150.trees;

public class SumOfNodes {

    public static void main(String[] args) {

    }
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        // Return the sum of all nodes in the binary tree
        return leftSum + rightSum + root.data;
    }
}
