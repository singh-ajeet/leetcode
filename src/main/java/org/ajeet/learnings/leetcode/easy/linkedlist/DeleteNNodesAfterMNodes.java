package org.ajeet.learnings.leetcode.easy.linkedlist;

public class DeleteNNodesAfterMNodes {

    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode previous = head;
        ListNode current = head;

        while(current != null){
            int m1 = m;
            int n1 = n;
            while(m1 > 0 && current != null){
                previous = current;
                current = current.next;
                m1--;
            }

            while(n1 > 0 && current != null){
                current = current.next;
                n1--;
            }
            previous.next = current;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next  = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;
        ListNode node7 = new ListNode(7);
        node6.next = node7;
        ListNode node8 = new ListNode(8);
        node7.next = node8;
        ListNode node9 = new ListNode(9);
        node8.next = node9;
        ListNode node10 = new ListNode(10);
        node9.next = node10;
        ListNode node11 = new ListNode(11);
        node10.next = node11;
        ListNode node12 = new ListNode(12);
        node11.next = node12;
        ListNode node13 = new ListNode(13);
        node12.next = node13;

        System.out.println(deleteNodes(node1, 2, 3));
    }
}
