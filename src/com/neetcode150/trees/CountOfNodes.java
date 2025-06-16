package com.neetcode150.trees;

public class CountOfNodes {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        // Return the total count of nodes in the binary tree
        return leftCount + rightCount + 1;
    }

}
