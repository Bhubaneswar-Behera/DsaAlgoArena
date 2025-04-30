package com.leetcode.journey.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        Node result = connect(root);
        printTreeWithNextPointers(result);
    }
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Connect the previous node's next to the current node
                if (prev != null) {
                    prev.next = current;
                }
                prev = current;

                // Add children to the queue
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            // The last node in the level will have its next pointer as null
        }

        return root;
    }

    // Helper method to print the tree with next pointers
    private  static void printTreeWithNextPointers(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node current = levelStart;
            levelStart = null;

            while (current != null) {
                System.out.print(current.val + " -> ");
                if (levelStart == null) {
                    if (current.left != null) {
                        levelStart = current.left;
                    } else if (current.right != null) {
                        levelStart = current.right;
                    }
                }
                current = current.next;
            }
            System.out.println("NULL");
        }
    }
}
