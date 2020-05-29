package org.ajeet.learnings.leetcode.easy.linkedlist;

public final class ReverseLinkedList {

    private static ListNode reverseList2(ListNode current, ListNode head) {
         if(current == null)
             return head;
         ListNode node = new ListNode(current.val);
         node.next = head;
         return reverseList2(current.next, node);
    }

    public static ListNode reverseList2(ListNode head) {
         return reverseList2(head, null);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newStart = null;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode current = new ListNode(tmp.val);
            current.next = newStart;
            newStart = current;
            tmp = tmp.next;
        }
        return newStart;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = reverseList(node1);

        System.out.println(result);
    }
}
