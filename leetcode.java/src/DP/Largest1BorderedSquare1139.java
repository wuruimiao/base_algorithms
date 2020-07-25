package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
* 1139. 最大的以 1 为边界的正方形 https://leetcode-cn.com/problems/largest-1-bordered-square/
给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。



示例 1：

输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
输出：9
示例 2：

输入：grid = [[1,1,0,0]]
输出：1


提示：

1 <= grid.length <= 100
1 <= grid[0].length <= 100
grid[i][j] 为 0 或 1
* */
public class Largest1BorderedSquare1139 {
    private void printDp(int[][][] dp) {
        for (int[][] i: dp){
            for (int [] j: i) {
                System.out.print(Arrays.toString(j));
            }
            System.out.println();
        }
    }

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        int left, up;

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int leftNum = 1, upNum = 1;
                if (grid[i][j] == 0) {
                    leftNum = 0;
                    upNum = 0;
                } else {
                    if (j > 0) {
                        leftNum = dp[i][j-1][0] + 1;
                    }
                    if (i > 0) {
                        upNum = dp[i-1][j][1] + 1;
                    }
                }

                // 向左持续为1的个数，向上持续为1的个数
                dp[i][j] = new int[]{leftNum, upNum};
                int num = Math.min(leftNum, upNum);
//                System.out.println(11111 + " " + leftNum + " " + upNum);
//                printDp(dp);
                // 检查边界是否都是1，否则缩小
                while (num > max) {
                    left = j - num + 1;
                    up = i - num +1;
//                    System.out.println(left + " " + up);
                    if (i - dp[i][left][1] < up && j - dp[up][j][0] < left) {
                        max = Math.max(max, num);
                        break;
                    }
                    num--;
                }
            }
        }
//        printDp(dp);
//        System.out.println(max);
        return max * max;
    }

    public static void main(String[] args) {
        Largest1BorderedSquare1139 t = new Largest1BorderedSquare1139();
        System.out.println(t.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}) + "==9");
        System.out.println(t.largest1BorderedSquare(new int[][]{{1,1,0,0}}) + "==1");
        System.out.println(t.largest1BorderedSquare(new int[][]{{0,0,0,1}}) + "==1");
        System.out.println(t.largest1BorderedSquare(new int[][]{{0,1}, {1,1}}) + "==1");
    }
}
