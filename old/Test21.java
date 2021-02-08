package com.leetcode.old;


/**
 * @Author 97683
 * @Date 2021/2/4 17:25
 * @Version 1.0
 */
public class Test21 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println("listNode = " + listNode);

        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(1);
        System.out.println("listNode1 = " + listNode1);

        Solution21 solution21 = new Solution21();
        ListNode listNode2 = solution21.mergeTwoLists(listNode, listNode1);
        System.out.println("listNode2 = " + listNode2);

    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 使用迭代法
        ListNode keeper = new ListNode(-1);
        ListNode pre = keeper;

        // 进行遍历
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        // 进行剩余拼接
        pre.next = l1 == null ? l2 : l1;
        return keeper.next;
    }
}