package com.neetcode150.trees;

/**
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        boolean result = solution.isSubtree(root, subRoot);
        System.out.println("Is subtree: " + result); // Should print true
    }
    // Checks whether subRoot exists as a subtree inside root
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // An empty tree is always a subtree
        if (subRoot == null) {
            return true;
        }

        // If main tree becomes empty but subRoot still exists,
        // then subtree cannot be found
        if (root == null) {
            return false;
        }

        // Check if both trees are identical starting from current node
        if (isIdentical(root, subRoot)) {
            return true;
        }

        // Otherwise, recursively check in left and right subtrees
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }
    // Checks whether two trees are exactly identical
    private boolean isIdentical(TreeNode root, TreeNode subRoot) {

        // Both nodes are null -> trees match
        if (root == null && subRoot == null) {
            return true;
        }

        // If one node is null OR values are different,
        // then trees are not identical
        if (root == null || subRoot == null
                || root.val != subRoot.val) {
            return false;
        }

        // Recursively compare left and right subtrees
        return isIdentical(root.left, subRoot.left)
                && isIdentical(root.right, subRoot.right);
    }
}
