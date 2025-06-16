package com.neetcode150.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Reference : https://www.youtube.com/watch?v=-DzowlcaUmE&t=13s
 */
public class BinaryTrees {
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
    // This class builds a binary tree from an array representation
    static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] nodes){
            index++;
            if(index >= nodes.length || nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void InOrder(Node root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Use null as a marker for the end of the current level
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;// Exit if the queue is empty after printing the current level
                } else {
                    queue.add(null); // Add a new null marker for the next level
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }




    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root =  binaryTree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("Pre Order Traversal starts");
        preOrder(root);
        System.out.println();
        System.out.println("Pre Order Traversal completed:");
        System.out.println();
        System.out.println("In Order Traversal starts");
        InOrder(root);
        System.out.println();
        System.out.println("In Order Traversal completed:");
        System.out.println();
        System.out.println("Post Order Traversal starts");
        postOrder(root);
        System.out.println();
        System.out.println("Post Order Traversal completed:");
        System.out.println();
        System.out.println("Level Order Traversal starts");
        levelOrder(root);
        System.out.println("Level Order Traversal completed:");
    }
}
