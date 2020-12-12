package org.ajeet.learnings.leetcode.easy.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ListNode[" + val);
        ListNode tmp = next;
        while (tmp != null) {
            builder.append(" -> " + tmp.val);
            tmp = tmp.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
