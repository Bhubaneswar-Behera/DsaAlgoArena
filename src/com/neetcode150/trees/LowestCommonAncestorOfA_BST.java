package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * Reference : https://www.youtube.com/watch?v=oX5D0uKOMck&t=6s
 */
public class LowestCommonAncestorOfA_BST {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        LowestCommonAncestorOfA_BST solution = new LowestCommonAncestorOfA_BST();
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.left.right; // Node with value 4
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val); // Should print 2
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If root is null, return null
        if (root == null) {
            return null;
        }

        // If root is equal to either p or q, then root is the LCA
        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both left and right LCA are not null, then root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        // If only one of the left or right LCA is not null, return that one
        else if (leftLCA != null) {
            return leftLCA;
        } else if (rightLCA != null) {
            return rightLCA;
        }
       // If both left and right LCA are null, return null
        return null;
       }
}
