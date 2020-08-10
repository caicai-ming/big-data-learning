package org.java.leetcode;

import java.util.Stack;

/**
 * ====链表专题====
 * 1.约瑟夫环
 * 2.反转部分单链表
 * 3.回文结构
 * 4.左小右大
 */
public class Day811 {

    public static void main(String[] args) {

    }

    //1.约瑟夫环
    public ListNode josephusKill(ListNode head, int k) {
        if (head == null || head.next == head || k < 1) {
            return head;
        }
        ListNode last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == k) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    //2.反转部分单链表
    public ListNode reversePart(ListNode head, int from, int to) {

        int len = 0;
        ListNode node1 = head;
        ListNode fPre = null;
        ListNode tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }

        if (head == null || from < to || to > len || from < 1) {
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        ListNode node2 = node1.next;
        node1.next = tPos;
        ListNode next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    //3.判断一个链表是否为回文结构
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //4.左小右大

    public ListNode listPartition(ListNode head, int pivot) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        ListNode[] nodeArr = new ListNode[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i].next = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i--) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public void arrPartition(ListNode[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].val == pivot) {
                index++;
            } else {
                swap(nodeArr, index, --big);
            }
        }
    }

    public void swap(ListNode[] nodeArr, int a, int b) {
        ListNode tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

}
