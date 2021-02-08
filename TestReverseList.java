package com.leetcode;

/**
 * @Author 97683
 * @Date 2021/2/8 15:24
 * @Version 1.0
 */
public class TestReverseList {
    public static void main(String[] args) {
        MyListNode head = new MyListNode(1);
        head.next = new MyListNode(2);
        head.next.next = new MyListNode(3);
        MyListNode tail = new MyListNode(4);
        head.next.next.next = tail;



        System.out.println("OriginList = " + head);
        MyListNode myListNode = TestReverseList.reverseHelper(head, tail);
        System.out.println("myListNode = " + myListNode);


    }

    public static MyListNode reverseHelper(MyListNode head, MyListNode tail) {
        MyListNode cur = head;
        MyListNode pre = null;
        MyListNode next;

        while (cur != tail) {
            next = cur.next;
            cur.next = pre;

            // 往下迭代
            pre = cur;
            cur = next;
        }
        // 边界
        tail.next = pre;

        return tail;
    }

}

class MyListNode {
    int val;
    MyListNode next;

    MyListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "MyListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
