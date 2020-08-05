package org.java.leetcode;

/**
 * 1.打印两个链表的公共部分
 * 2.删除倒数第k个节点
 * 3.删除中间节点
 */
public class Day806 {
    public static void main(String[] args) {

    }

    //1.打印两个链表的公共部分
    public static void printCommenPart(ListNode head1, ListNode head2) {

        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.val < head2.val) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

    }

    //2.删除倒数第k个节点
    public static ListNode removeLastKth1(ListNode head, int k) {
        if (head == null || k < 0) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static ListNode removeLastKth2(ListNode head, int k) {
        if (head == null || k < 0) {
            return head;
        }
        ListNode cur1 = head;
        ListNode cur2 = head;
        while (k > 0 && cur2 != null) {
            cur2 = cur2.next;
            k--;
        }
        if (k == 0 && cur2 == null) {
            head = head.next;
        }
        else if (cur2 != null) {
            while (cur2 != null) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            cur1.next = cur1.next.next;
        }

        return head;
    }



    //3.删除中间节点


}
