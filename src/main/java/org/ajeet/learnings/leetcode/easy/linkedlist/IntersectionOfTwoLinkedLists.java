package org.ajeet.learnings.leetcode.easy.linkedlist;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int size1 = getSize(headA);
        int size2 = getSize(headB);

        if(size1 > size2){
            return getIntersection(headA,headB, size1 - size2);
        } else {
            return getIntersection(headB, headA, size2 - size1);
        }
    }

    private static int getSize(ListNode node){
        int size = 0;
        ListNode tmp = node;
        while(tmp != null){
            size++;
            tmp = tmp.next;
        }
        return size;
    }

    private static ListNode getIntersection(ListNode first, ListNode second, int diff){
        ListNode tmp1 = first;
        while(diff > 0){
            tmp1 = tmp1.next;
            diff--;
        }

        ListNode tmp2 = second;
        while(tmp1 != null && tmp2 != null){
            if(tmp1 == tmp2){
                return tmp1;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return null;
    }
}
