package org.ajeet.learnings.algorithms.bitwise;

import org.ajeet.learnings.leetcode.easy.linkedlist.ListNode;

public class BinaryLinkedListToNumber {

    public static int getDecimalValue(ListNode head) {
        int result = 0b0;
        ListNode tmp = head;
        while(tmp != null){
            result = result << 1;
            result = result | tmp.val;
            tmp = tmp.next;
        }
        return Integer.valueOf(result);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(0);
        ListNode next2 = new ListNode(1);

        head.next = next1;
        next1.next = next2;

        System.out.println(getDecimalValue(head));
    }
}
