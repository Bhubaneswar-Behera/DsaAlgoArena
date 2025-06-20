package com.neetcode150.trees;

import java.util.ArrayList;

/**
 *
 * Reference : https://www.youtube.com/watch?v=qAeitQWjNNg&t=3127s
 */
public class BST {

  public static Node insert(Node root, int value) {
      if (root == null) {
          Node newNode = new Node(value);
          return newNode;
      }
      if (value < root.data) {
          root.left = insert(root.left, value);
      } else if (value > root.data) {
          root.right = insert(root.right, value);
      }
      return root;
  }
    public boolean search(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        } else if (value < root.data) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }
    public Node delete(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.data) {
            root.left = delete(root.left, value);
        } else if (value > root.data) {
            root.right = delete(root.right, value);
        } else {
            // Case 1 : Node with no child
            if (root.left == null && root.right == null) {
                return null;
            }
            //Case 2 : Node with one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3 :  Node with two children: Get the inorder successor (smallest in the right subtree)
            Node successor = findInOrderSuccessor(root.right);
            root.data = successor.data; // Copy the inorder successor's content to this node
            root.right = delete(root.right, successor.data); // Delete the inorder successor
        }
        return root;
    }
    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void printInRange(Node root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.data >= low && root.data <= high) {// If current node's value is in range, print it
            printInRange(root.left, low, high);
            System.out.print(root.data + " ");
            printInRange(root.right, low, high);
        } else if (root.data >= high) {// If current node's value is greater than high, go left
            printInRange(root.left, low, high);
        } else {// If current node's value is less than low, go right
            printInRange(root.right, low, high);
        }
    }
    public static void printRootToLeafPaths(Node root, ArrayList<Integer > path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {// If it's a leaf node, print the path
            printPaths(path);
        } else {
            // If not leaf node, continue to traverse
            printRootToLeafPaths(root.left, path);
            printRootToLeafPaths(root.right, path);
        }
        // Backtrack to remove the current node from the path
        path.remove(path.size() - 1);
    }
    public static void printPaths(ArrayList<Integer > path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"-->");
        }
        System.out.println();
    }

    public static void inorderTraversal(Node root) {
      if (root == null) {
          return;
      }
      inorderTraversal(root.left);
      System.out.print(root.data + " ");
      inorderTraversal(root.right);
  }
    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        Node root = null;
        for (int i = 0; i < values.length ; i++) {
            root = insert(root, values[i]);
        }
        inorderTraversal(root);
        //System.out.println();
        //System.out.println("Search 1: " + new BST().search(root, 1));

        int[] values1 = {8,5,3,1,4,6,10,11,14};
        Node root1 = null;
        for (int i = 0; i < values1.length ; i++) {
            root1 = insert(root1, values1[i]);
        }
        inorderTraversal(root1);
        System.out.println();
        printInRange(root1,6,10);
        System.out.println();
        int[] values2 = {8,5,3,6,10,11,14};
        Node root2 = null;
        for (int i = 0; i < values2.length ; i++) {
            root2 = insert(root2, values2[i]);
        }
        printRootToLeafPaths(root2, new ArrayList<>());
    }
}
