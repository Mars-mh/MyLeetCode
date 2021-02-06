package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author 97683
 * @Date 2021/2/5 15:59
 * @Version 1.0
 */
public class Test31 {
    public static void main(String[] args) {
        int[] ints = {6, 5, 4, 3, 2, 1, 0};
        System.out.println("ints.length = " + ints.length);
        Arrays.sort(ints, 3, ints.length);
        for (int i : ints) {
            System.out.println("i = " + i);
        }
    }
}
