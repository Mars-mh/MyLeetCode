package com.leetcode.old;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author 97683
 * @Date 2021/1/19 9:50
 * @Version 1.0
 */
public class Test1584 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int i = solution.minCostConnectPoints(points);
        System.out.println("最小距离为： = " + i);
    }
}

class Edges {
    /**
     * 定义图
     */
    int a;
    int b;
    int dis;

    public Edges(int a, int b, int dis) {
        this.a = a;
        this.b = b;
        this.dis = dis;
        }
}

class Solution {
    /**
     * 解决方法
     * 输入：points int[][]
     * 输出：res int
     */

    ArrayList<Integer> pointsList;

    public int minCostConnectPoints(int[][] points) {

        int length = points.length;

        // 创建并查集
        pointsList = new ArrayList<>();
        // 先将各个点作为独立的单位放入集合
        for (int i = 0; i < length; i++) {

            pointsList.add(i);
        }

        // 定义边集合
        ArrayList<Edges> edges = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 计算距离
                int dis = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                // 循环写入各点
                edges.add(new Edges(i, j, dis));
            }
        }

        // 对边进行排序，按照边的权重
        edges.sort(Comparator.comparingInt(a -> a.dis));
        int res = 0;

        // 遍历边集合
        for (Edges e: edges) {
            // 查询根节点
            int a = findRoot(e.a);
            int b = findRoot(e.b);

            // 若不联通则加入集合
            if (a != b) {
                // 将点进行联通
                pointsList.set(a,b);
                // 将边长写入最终结果
                res += e.dis;
            }
        }
        return res;
    }

    public int findRoot(int x) {
        /*
        寻根函数：并查集
         */
        if ( pointsList.get(x) != x) {
            pointsList.set(x,findRoot(pointsList.get(x)));
        }

        return pointsList.get(x);
    }
}