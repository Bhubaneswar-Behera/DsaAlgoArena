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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
           int levelSize = queue.size();// Get the number of nodes at the current level
           List<Integer> currentLevel = new ArrayList<>();// Create a list to store the values of nodes at the current level

            // Iterate through all nodes at the current level
           for (int i = 0; i < levelSize; i++) {
               TreeNode currentNode = queue.poll();// Remove the front node from the queue
               currentLevel.add(currentNode.val);

               if (currentNode.left != null) {
                    queue.add(currentNode.left);
               }
               if (currentNode.right != null) {
                    queue.add(currentNode.right);
               }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
