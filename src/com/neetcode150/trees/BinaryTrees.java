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
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        // Return the total count of nodes in the binary tree
        return leftCount + rightCount + 1;
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

    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        // Return the height of the binary tree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Time Complexity: O(n2)
    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int currentDiameter = leftHeight + rightHeight + 1;
        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);
        // Return the maximum diameter found in the binary tree
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }
    //Time Complexity: O(n)
    public static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameterOptimized(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftInfo = diameterOptimized(root.left);
        TreeInfo rightInfo = diameterOptimized(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int leftDiameter = leftInfo.diameter;
        int rightDiameter = rightInfo.diameter;
        int currentDiameter = leftDiameter + rightDiameter + 1;

        int diameter = Math.max(currentDiameter, Math.max(leftInfo.diameter, rightInfo.diameter));

        return new TreeInfo(height, diameter);
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
        System.out.println();
        System.out.println("Count of nodes starts");
        System.out.println(countNodes(root));
        System.out.println("Count of nodes completed:");
        System.out.println();
        System.out.println("Sum of nodes starts");
        System.out.println(sumOfNodes(root));
        System.out.println("Sum of nodes completed:");
        System.out.println();
        System.out.println("Height of tree starts");
        System.out.println(heightOfTree(root));
        System.out.println("Height of tree completed:");
        System.out.println();
        System.out.println("Diameter of tree starts");
        System.out.println(diameterOfTree(root));
        System.out.println("Diameter of tree completed:");
        System.out.println();
        System.out.println("Diameter Optimized starts");
        TreeInfo treeInfo = diameterOptimized(root);
        System.out.println("Height: " + treeInfo.height);
        System.out.println("Diameter: " + treeInfo.diameter);
        System.out.println("Diameter Optimized completed:");

    }
}
