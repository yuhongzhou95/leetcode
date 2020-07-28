package com.shadow.leetcode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Q203 {
    public static void main(String[] args) {

    }

    /**
     * 不添加虚拟头节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 删除符合条件的所有头元素
        while (head != null && head.val == val) {
            ListNode deleteNode = head;
            head = deleteNode.next;
            deleteNode = null;
        }
        if (head == null) {
            return null;
        }
        // 删除符合条件的中间元素
        ListNode previousNode = head;
        while (previousNode.next != null) {
            if (previousNode.next.val == val) {
                ListNode deleteNode = previousNode.next;
                previousNode.next = deleteNode.next;
                deleteNode = null;
            } else {
                previousNode = previousNode.next;
            }
        }
        return head;
    }

    /**
     * 添加虚拟头结点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode previousNode = dummyHead;
        dummyHead.next = head;
        while (previousNode.next != null) {
            if (previousNode.next.val == val) {
                ListNode deleteNode = previousNode.next;
                previousNode.next = deleteNode.next;
                deleteNode = null;
            } else {
                previousNode = previousNode.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归删除
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements3(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
/*class ListNode {
    int val;
    com.shadow.ListNode next;

    ListNode(int x) {
        val = x;
    }
}*/

