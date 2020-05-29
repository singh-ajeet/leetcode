package org.ajeet.learnings.leetcode.easy.linkedlist;

public final class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;

        ListNode head2 = new ListNode(head.val);
        ListNode tmp = head.next;

        while (tmp != null) {
            ListNode node = new ListNode(tmp.val);
            node.next = head2;
            head2 = node;
            tmp = tmp.next;
        }

        tmp = head;
        while(tmp != null) {
            if(tmp.val != head2.val)
                return false;
            tmp = tmp.next;
            head2 = head2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
/*        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
*/

        System.out.println(isPalindrome(node1));
    }
}
