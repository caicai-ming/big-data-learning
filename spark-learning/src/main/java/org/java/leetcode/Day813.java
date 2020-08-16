package org.java.leetcode;

public class Day813 {
    public static void main(String[] args) {

    }

    //1.合并两个有序单链表
    public ListNode mergeListNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val < head2.val ? head1 : head2;

        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;

        ListNode pre = cur1;
        ListNode next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                cur2.next = pre.next;
                pre.next = cur2;
                pre = cur2;
                cur2 = next;
            }
        }

        pre.next = cur1 == null ? cur2 : cur1;

        return head;
    }

    //2.环形链表约瑟夫环
    public ListNode yuesefu(ListNode head, int k) {
        ListNode last = head.next;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            count++;
            if (count == k) {
                last.next = head.next;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }


}
