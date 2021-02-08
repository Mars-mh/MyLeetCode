package com.leetcode.old;

/**
 * @Author 97683
 * @Date 2021/2/4 15:26
 * @Version 1.0
 */
public class Test19 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println("node = " + node);

        SolutionA solutionA = new SolutionA();
        ListNode listNode = solutionA.removeNthFromEnd(node, 2);
        System.out.println("listNode = " + listNode);
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

     @Override
     public String toString() {
         return "ListNode{" +
                 "val=" + val +
                 ", next=" + next +
                 '}';
     }
 }

class SolutionA {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0, head);
        // 定义快慢指针
        ListNode first = head;
        ListNode second = listNode;
        // 首个指针移动
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        // 首指针移到终点，次指针移到n
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = listNode.next;
        return ans;
    }
}
