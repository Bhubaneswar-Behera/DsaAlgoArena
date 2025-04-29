package com.leetcode.journey.trees;

import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BSTIterator {
    public static void main(String[] args) {
            TreeNode root = new TreeNode(7);
            root.left = new TreeNode(3);
            root.right = new TreeNode(15);
            root.right.left = new TreeNode(9);
            root.right.right = new TreeNode(20);

            BSTIterator iterator = new BSTIterator(root);
            System.out.println(iterator.next());    // Output: 3
            System.out.println(iterator.next());    // Output: 7
            System.out.println(iterator.hasNext()); // Output: true
            System.out.println(iterator.next());    // Output: 9
            System.out.println(iterator.hasNext()); // Output: true
            System.out.println(iterator.next());    // Output: 15
            System.out.println(iterator.hasNext()); // Output: true
            System.out.println(iterator.next());    // Output: 20
            System.out.println(iterator.hasNext()); // Output: false
        }


    private Stack<TreeNode> stack;

    // Constructor to initialize the iterator with the root of the BST
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftNodes(root); // Push all the left nodes of the tree to the stack
    }

    // Returns true if there is a next smallest number in the BST
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Returns the next smallest number in the BST
    public int next() {
        TreeNode node = stack.pop(); // Get the top node from the stack
        if (node.right != null) {
            pushLeftNodes(node.right); // Push all the left nodes of the right subtree
        }
        return node.val; // Return the value of the current node
    }

    // Helper method to push all left nodes of a subtree to the stack
    private void pushLeftNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
