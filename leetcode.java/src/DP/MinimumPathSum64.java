package DP;

/*
* 64. 最小路径和 https://leetcode-cn.com/problems/minimum-path-sum/
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
* */
public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        int tmp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i==0) tmp = dp[i][j-1];
                else if (j==0) tmp = dp[i-1][j];
                else tmp = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = tmp + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
