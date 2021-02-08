package com.leetcode.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 97683
 * @Date 2021/2/4 10:53
 * @Version 1.0
 */
public class Test15 {
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 倒序指针
        int k = n - 1;
        // 对于数组进行排序
        Arrays.sort(nums);

        // 循环 + 双指针
        for (int i = 0; i < n ; i++) {

            // 第一层循环出现与上次循环相同的数值则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n ; j++) {

                // 第二层循环出现与上次相同则跳过
                if (j > i + 1 && nums[j] == nums[j -1]) {
                    continue;
                }

                // 双指针条件判断
                while (j < k && nums[i] + nums[j]  + nums[k] > 0) {
                    k = k - 1;
                }
                // 当指针重合时退出循环，因为不能存在重复
                if (j == k) {
                    break;
                }

                // 当满足结果时压入结果List
                if (nums[i] + nums[j] + nums[k] ==0) {
                    ArrayList<Integer> ints = new ArrayList<>();
                    ints.add(nums[i]);
                    ints.add(nums[j]);
                    ints.add(nums[k]);
                    ans.add(ints);
                }
            }
        }
        return ans;
    }
}
