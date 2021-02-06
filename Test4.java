package com.leetcode;

/**
 * @Author 97683
 * @Date 2021/1/29 16:24
 * @Version 1.0
 */
public class Test4 {
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 8, 9};
        int[] b = {7,10,22};

        Solution4 solution4 = new Solution4();
        double v1 = solution4.mySolution1(a, b);
        System.out.println("v1 = " + v1);

        double v2 = solution4.mySolution2(a, b);
        System.out.println("v2 = " + v2);

    }
}

class Solution4{
    public double mySolution1(int[] a, int[] b) {
        int lengthA = a.length;
        int lengthB = b.length;
        int n = lengthA + lengthB;
        int left = 0, right = 0;

        int[] ans = new int[n];
        int index = 0;

        // 归并
        while (left < lengthA && right <lengthB){
            if (a[left] < b[right]) {
                ans[index++] = a[left++];
            }else {
                ans[index++] = b[right++];
            }
        }

        while (left < lengthA) {
            ans[index++] = a[left++];
        }

        while (right < lengthB) {
            ans[index++] = a[right++];
        }

        // 找到中位数
        if ((n & 1) == 0){
            return (double) (ans[(lengthA + lengthB)/2] + ans[(lengthA + lengthB)/2 - 1])/2;
        }else {
            return (double) ans[(lengthA + lengthB)/2];
        }
    }

    public double mySolution2(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int len = n + m;

        // 保存遍历的数值
        int pre = 0;
        int cur = 0;

        // 进行遍历
        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i <= len/2; i++) {
            // 进行同步
            pre = cur;

            if (indexA < n && (a[indexA] < b[indexB] || indexB >= m)) {
                cur = a[indexA++];
            }else {
                cur = b[indexB++];
            }

        }
        if ((len & 1) == 0) {
            return (cur + pre) / 2.0;
        } else {
            return cur;
        }
    }

    public double mySolution3(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
