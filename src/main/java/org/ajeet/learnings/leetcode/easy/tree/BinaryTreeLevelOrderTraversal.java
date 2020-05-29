package org.ajeet.learnings.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.List;

public final class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        levelOrder(root, 0, levels);
        return levels;
    }

    private static void levelOrder(TreeNode root, int level, List<List<Integer>> levels) {
        if(root == null)
            return;
        if(levels.size() < level + 1)
            levels.add(new ArrayList<>());

        levels.get(level).add(root.val);
        ++level;
        levelOrder(root.left, level, levels);
        levelOrder(root.right, level, levels);
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        node3.left = node9;
        node3.right = node20;

        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node20.left = node15;
        node20.right  = node7;

        System.out.println(levelOrder(node3));
    }
}
