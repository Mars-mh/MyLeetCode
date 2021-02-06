package com.leetcode;

import java.util.Stack;

/**
 * @Author 97683
 * @Date 2021/2/5 16:27
 * @Version 1.0
 */
public class Test32 {
    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int i = solution32.longestValidParentheses("()(()");
        System.out.println("i = " + i);
    }
}

class Solution32 {
    public int longestValidParentheses(String s) {
        // 边界情况
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }

        // 进行遍历
        int ans = 0;
        int l = s.length();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < l; i++) {
            // 左进，右出
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
