package com.neetcode150.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Reference : https://www.youtube.com/watch?v=BnOjzXe6J-Y
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        List<Integer> rightSideView = solution.rightSideView(root);
        System.out.println("Right Side View: " + rightSideView); // Output: [1, 3, 4]
    }
    //Time Complexity: O(N) where N is the number of nodes in the tree.
    //Space Complexity: O(N) for the queue used in BFS.
    // Returns the nodes visible from the right side of the binary tree
    public List<Integer> rightSideView(TreeNode root) {

        // Stores the final right-side view result
        List<Integer> result = new ArrayList<>();

        // If tree is empty, return empty result
        if (root == null) {
            return result;
        }

        // Queue is used for Level Order Traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();

        // Start traversal from root node
        queue.add(root);

        // Continue until all nodes are processed
        while (!queue.isEmpty()) {

            // Number of nodes present at current level
            int levelSize = queue.size();

            // Stores the value of the last node at current level
            int lastValue = 0;

            // Process all nodes of current level
            for (int i = 0; i < levelSize; i++) {

                // Remove front node from queue
                TreeNode node = queue.poll();

                // Keep updating lastValue
                // Final value after loop ends will be the rightmost node
                lastValue = node.val;

                // Add left child to queue for next level processing
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child to queue for next level processing
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Add the rightmost node value of current level
            result.add(lastValue);
        }

        // Return right-side view of the binary tree
        return result;
    }
}
