package DP.Walk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。



例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。



说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
* */
public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int [] dp = new int[triangle.get(triangle.size()-1).size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i] = dp[i-1] + triangle.get(i).get(i);
            for (int j = i-1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
        }
        int min = dp[0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Triangle120 t = new Triangle120();
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(Arrays.asList(2));
        tri.add(Arrays.asList(3, 4));
        tri.add(Arrays.asList(6, 5, 7));
        tri.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(t.minimumTotal(tri) + "==11");
    }
}
