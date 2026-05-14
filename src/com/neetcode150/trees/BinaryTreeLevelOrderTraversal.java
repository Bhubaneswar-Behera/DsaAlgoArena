package com.neetcode150.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> result = tree.levelOrder(root);
        System.out.println(result); // [[1], [2, 3], [4, 5, 6]]
    }
    // Performs Level Order Traversal (Breadth-First Search)
// and returns node values level by level
    public List<List<Integer>> levelOrder(TreeNode root) {

        // Stores the final result
        List<List<Integer>> result = new ArrayList<>();

        // If tree is empty, return empty result
        if (root == null) {
            return result;
        }

        // Queue is used for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Add root node to start traversal
        queue.add(root);

        // Continue traversal until queue becomes empty
        while (!queue.isEmpty()) {

            // Number of nodes present at current level
            int levelSize = queue.size();

            // Stores all node values of current level
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes of current level
            for (int i = 0; i < levelSize; i++) {

                // Remove front node from queue
                TreeNode currentNode = queue.poll();

                // Add current node value to level list
                currentLevel.add(currentNode.val);

                // Add left child to queue if present
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add right child to queue if present
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Add current level data to final result
            result.add(currentLevel);
        }

        // Return level order traversal result
        return result;
    }
}
