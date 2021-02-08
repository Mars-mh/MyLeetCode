package com.leetcode.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 97683
 * @Date 2021/2/4 12:13
 * @Version 1.0
 */
public class Test17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations("23");

    }
}

class Solution17 {
    public List<String> letterCombinations(String digits) {
        // 最终组合结果
        List<String> combinations = new ArrayList<String>();
        // 如果为空返回空
        if (digits.length() == 0) {
            return combinations;
        }
        // 定义“数字-字幕”对应 Map
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        // 调用函数
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        // 返回最终结果
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer str) {
        // 递归函数出口
        if (index == digits.length()) {
            combinations.add(str.toString());
        } else {
            // 当前数字
            char digit = digits.charAt(index);
            // 当前数字对应字母的字符串
            String letters = phoneMap.get(digit);
            // 对应字符串的长度
            int lettersCount = letters.length();

            for (int i = 0; i < lettersCount; i++) {

                str.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, str);
                str.deleteCharAt(index);
            }
        }
    }
}
