package com.leetcode.old;

/**
 * @Author 97683
 * @Date 2021/2/1 17:19
 * @Version 1.0
 */
public class Test10 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a";

        Solution10 solution10 = new Solution10();
        boolean match = solution10.isMatch(s, p);
        System.out.println("match = " + match);
    }

}

class Solution10 {
    public boolean isMatch(String s, String p) {
        // 初始量
        int m = s.length();
        int n = p.length();

        // 初始化状态转移矩阵确定
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 初始化首列状态
        dp[0][0] = true;
        // 初始化首行状态
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i -1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }

        // 状态更新
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                // case-1
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                    // case-2
                }else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    }else {
                        //case-3
                        dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
                    }
                }
            }
        }
        // 返回结果
        return dp[m][n];
    }
}