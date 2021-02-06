package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 97683
 * @Date 2021/2/4 19:26
 * @Version 1.0
 */
public class Test22 {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.genParentheses(3);
        System.out.println();
        for (String s : strings) {
            System.out.println("s = " + s);
        }


    }
}

class Solution22 {
    public List<String> genParentheses(int n) {
        ArrayList<String> strings = new ArrayList<>();

        helper(strings, 0 , 0, n, "");
        return strings;
    }

    void helper(ArrayList<String> strings, int left, int right, int n, String str) {
        // 出口
        if (left == n && right == n) {
            strings.add(str.toString());
            return;
        }

        // 减枝
        if (left > n || left < right) {
            return;
        }

        // 递归
        helper(strings, left + 1, right, n, str + "(");
        System.out.println("str = " + str);
        helper(strings, left, right + 1, n, str + ")");


    }
}
