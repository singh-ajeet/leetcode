package org.ajeet.learnings.leetcode.easy.tree;

public final class SymmetricTree {

    private static boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public static boolean isSymmetric(TreeNode node) {
        return isMirror(node, node);
    }
}
