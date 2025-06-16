package com.neetcode150.trees;

public class BuildTreeFromPreOrder {
    static int index = -1;
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
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTreeFromPreOrder(nodes);
        System.out.println("Tree built from pre-order traversal.");
        //print the root
        System.out.println("Root Node: " + root.data);
    }
    public static Node buildTreeFromPreOrder(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }

        Node node = new Node(nodes[index]);
        node.left = buildTreeFromPreOrder(nodes);
        node.right = buildTreeFromPreOrder(nodes);

        return node;
    }

}
