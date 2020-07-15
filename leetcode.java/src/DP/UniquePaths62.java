package DP;


/*
* 62. 不同路径 https://leetcode-cn.com/problems/unique-paths/
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？



例如，上图是一个7 x 3 的网格。有多少可能的路径？



示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28


提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9
* */
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j== 0) continue;
                if (i==0) tmp = dp[i][j-1];
                else if (j==0) tmp = dp[i-1][j];
                else tmp = dp[i-1][j] + dp[i][j-1];
                dp[i][j] = tmp;
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        UniquePaths62 t = new UniquePaths62();
        System.out.println(t.uniquePaths(3, 2) + "==3");
        System.out.println(t.uniquePaths(7, 3) + "==28");
    }
}
