package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/same-tree/description/
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        SameTree st = new SameTree();
        System.out.println(st.isSameTree(p, q)); // Output: true
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }
        // If one of the nodes is null, they are not the same
        if (p == null || q == null) {
            return false;
        }
        // Check if the current nodes have the same value
        if (p.val != q.val) {
            return false;
        }
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
