package com.javainterview.app.treeInterview;


/**
 * Reverse the nodes in a binary tree
 * 4
 * 2   7
 *
 * 4
 * 7   2
 *
 * Solution:
 * Use DFS and switch the left and right nodes.
 * DFS is O(n) because we are visiting all nodes.
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }

}