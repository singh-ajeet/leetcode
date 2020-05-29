package org.ajeet.learnings.leetcode.easy.linkedlist;

public final class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }
}
