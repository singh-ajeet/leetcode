package org.ajeet.learnings.leetcode.easy.tree;

public final class ConvertSortedArrayToBinarySearchTree {

    private static TreeNode sortedArrayToBST(int[] nums, int from, int to) {
        if(to < from )
            return null;

        int mid = (to + from) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, from, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, to);

        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] input = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(input));
    }
}
