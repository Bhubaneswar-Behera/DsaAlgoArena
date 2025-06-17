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

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {

    }
    //Time Complexity: O(N) where N is the number of nodes in the tree.
    //Space Complexity: O(N) for the queue used in BFS.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            int lastValue = 0;  // Store the last node's value of the level

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                lastValue = node.val;  // Update lastValue with the current node

                // Add child nodes to queue for next level processing
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(lastValue);  // Add the last node's value of this level
        }

        return result;
    }
}
