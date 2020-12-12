package org.ajeet.learnings.leetcode.easy.linkedlist;

public class MergeTwoSortedLinkedLists {

    public static ListNode merge(ListNode first, ListNode second) {
        if(first == null)
            return second;
        else if (second == null) {
            return first;
        }

        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode tmp = head;
        ListNode tmp1 = first;
        ListNode tmp2 = second;

        while (tmp1 != null || tmp2 != null) {
            if (tmp1 == null) {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            } else if(tmp2 == null){
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                if(tmp1.val < tmp2.val) {
                    tmp.next = tmp1;
                    tmp1 = tmp1.next;
                } else {
                    tmp.next = tmp2;
                    tmp2 = tmp2.next;
                }
            }
            tmp = tmp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
