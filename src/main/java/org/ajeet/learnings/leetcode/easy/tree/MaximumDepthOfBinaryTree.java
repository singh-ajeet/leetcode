package org.ajeet.learnings.leetcode.easy.tree;

public final class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
