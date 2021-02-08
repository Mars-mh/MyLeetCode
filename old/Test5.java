package com.leetcode.old;

/**
 * @Author 97683
 * @Date 2021/1/29 19:54
 * @Version 1.0
 */
public class Test5 {
    public static void main(String[] args) {
        String test = "MassaMabbCCCCCCCCCCCCCCCCCCCCCC";
        Solution5 solution5 = new Solution5();
        String s = solution5.mySolution(test);
        System.out.println("s = " + s);
    }
}

class Solution5 {
    public String mySolution(String s) {
        int length = s.length();
        boolean[][] booleans = new boolean[length][length];
        String ans = "";

        for (int l = 0; l < length; l++) {
            for (int i = 0; i + l < length; i++) {

                int j = i + l;
                boolean b = s.charAt(i) == s.charAt(j);

                if (l == 0){
                    booleans[i][i] = true;
                }else if (l == 1) {
                        booleans[i][j] = b;
                }else {
                    booleans[i][j] = (b && booleans[i+1][j-1]);
                }
                // 进行结果更新
                if (booleans[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }
}
