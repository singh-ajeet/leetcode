package org.ajeet.learnings.leetcode.easy.linkedlist;

public final class RemoveNthNodeFromEndOfList {

   public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode();
        tmp.next = head;

        ListNode first = tmp;
        int i=1;
        while(i <= n) {
            first = first.next;
            i++;
        }

        ListNode second = tmp;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        //Now second.next is deletion candidate, delete it
        ListNode deleteIt = second.next;
        second.next = deleteIt.next;
        deleteIt.next = null;
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
     /*   ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);


        node2.next = node3;
        node3.next = node4;
        node4.next = node5;*/

        ListNode result = removeNthFromEnd(node1, 1);

        System.out.println(result);
    }
}
