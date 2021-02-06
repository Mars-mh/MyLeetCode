package com.leetcode;

import java.util.*;

/**
 * @Author 97683
 * @Date 2021/2/4 16:40
 * @Version 1.0
 */
public class Test20 {
    public static void main(String[] args) {
        String str = "()";
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid(str);
        System.out.println("valid = " + valid);
    }
}

class Solution20 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
