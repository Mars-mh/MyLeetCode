package com.leetcode;

import java.util.PriorityQueue;

/**
 * @Author 97683
 * @Date 2021/2/5 11:43
 * @Version 1.0
 */
public class Test23 {
    public static void main(String[] args) {
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
    }
}
