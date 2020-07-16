package DP;

/*
* 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
* */
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 1;
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
                if (dp[i][j] > max) max = dp[i][j];
            }
        }
//        for (int[] item : dp) {
//            System.out.println(Arrays.toString(item));
//        }
        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare221 t = new MaximalSquare221();
        System.out.println(t.maximalSquare(new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'},
        }) + "== 4");
        System.out.println(t.maximalSquare(new char[][]{
                new char[]{'1'},
        }) + "== 1");
//        [["0","0","0","1"],["1","1","0","1"],["1","1","1","1"],["0","1","1","1"],["0","1","1","1"]]
        System.out.println(t.maximalSquare(new char[][]{
                new char[]{'0', '0', '0', '1'},
                new char[]{'1', '1', '0', '1'},
                new char[]{'1', '1', '1', '1'},
                new char[]{'0', '1', '1', '1'},
                new char[]{'0', '1', '1', '1'},
        }) + "== 9");
    }
}
