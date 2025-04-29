package com.leetcode.journey.trees;

/**
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node 5
        TreeNode q = root.right; // Node 1

        LowestCommonAncestorOfABinaryTree solution = new LowestCommonAncestorOfABinaryTree();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA: " + lca.val); // Output: 3
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null or matches either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recur for left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null value (either left or right)
        return left != null ? left : right;
    }
}
