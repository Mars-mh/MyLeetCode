package com.leetcode.old;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 97683
 * @Date 2021/1/19 17:39
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {2,7,8,9,6,5,4};
        int[] res = solution1.twoSum(nums, 9);
        System.out.println("res = " + Arrays.toString(res));
    }

}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}