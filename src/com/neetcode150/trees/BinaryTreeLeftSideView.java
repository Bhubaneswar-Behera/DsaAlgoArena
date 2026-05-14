package com.neetcode150.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *
 */
public class BinaryTreeLeftSideView {

    public static void main(String[] args) {
        BinaryTreeLeftSideView tree = new BinaryTreeLeftSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(tree.leftSideView(root)); // [1, 2, 4]
    }

    //Time Complexity : O(n)
    //Space Complexity : O(n)
    // Returns the nodes visible from the left side of the binary tree
    public List<Integer> leftSideView(TreeNode root) {

        // Stores the final left-side view result
        List<Integer> result = new ArrayList<>();

        // If tree is empty, return empty result
        if (root == null) {
            return result;
        }

        // Queue is used for Level Order Traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();

        // Start traversal from root node
        queue.add(root);

        // Continue traversal until queue becomes empty
        while (!queue.isEmpty()) {

            // Number of nodes present at current level
            int levelSize = queue.size();

            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {

                // Remove front node from queue
                TreeNode node = queue.poll();

                // First node encountered at each level
                // represents the leftmost node
                if (i == 0) {
                    result.add(node.val);
                }

                // Add left child to queue for next level processing
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child to queue for next level processing
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        // Return left-side view of the binary tree
        return result;
    }
}
