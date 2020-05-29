package org.ajeet.learnings.leetcode.easy.linkedlist;

public final class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
            else
                return false;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
 /*       ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
*/
       System.out.println(hasCycle(node1));
    }
}
