package org.ajeet.learnings.leetcode.easy.linkedlist;

public final class MergeTwoSortedLists {

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        while(tmp1 != null || tmp2 != null) {
            if(tmp1 == null) {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            } else if(tmp2 == null) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else if(tmp1.val < tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        return head.next;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        ListNode head;
        if(tmp1.val < tmp2.val) {
            head = new ListNode(tmp1.val);
            tmp1 = tmp1.next;
        } else {
            head = new ListNode(tmp2.val);
            tmp2 = tmp2.next;
        }

        ListNode tmp = head;

        while(tmp1 != null || tmp2 != null) {
            if(tmp1 == null) {
                tmp.next = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
            } else if(tmp2 == null) {
                tmp.next = new ListNode(tmp1.val);
                tmp1 = tmp1.next;
            } else if(tmp1.val < tmp2.val) {
                tmp.next = new ListNode(tmp1.val);
                tmp1 = tmp1.next;
            } else {
                tmp.next = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode result = mergeTwoLists2(node1, node4);

        System.out.println(result);
    }
}
