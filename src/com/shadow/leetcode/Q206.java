package com.shadow.leetcode;

/**
 * 反转链表
 */
public class Q206 {
    /**
     * 遍历
     *
     * @param head
     * @return
     */
    public ListNode reverseListByTraversal(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
