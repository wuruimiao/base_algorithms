package Array;

import java.util.Arrays;

/*
* 718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

示例：

输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。


提示：

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
* */
public class MaximumLengthOfRepeatedSubarray718 {
    private int getLen(int[] A, int[] B, int a, int b) {
        int len = 0;
        for (; a < A.length && b < B.length && A[a] == B[b]; a++, b++) {
            len++;
        }
        return len;
    }

    public int findLengthForce(int[] A, int[] B) {
        int i = 0, maxLen = 0;
        while (i < A.length) {
            int j = 0;
            while (j < B.length) {
                while (j < B.length && B[j] != A[i]) j++;
                if (j == B.length) continue;
                maxLen = Math.max(maxLen, getLen(A, B, i, j));
                j++;
            }
            i++;
        }
        return maxLen;
    }

    private int findLengthDP(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                max = Math.max(dp[i][j], max);
            }
        }

//        System.out.print("  ");
//        for (int a : A) {
//            System.out.print(a + "  ");
//        }
//        System.out.println();
//        for (int i = 0; i < dp.length - 1; i++) {
//            System.out.print(B[i]);
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return max;
    }


    public int findLength(int[] A, int[] B) {
        return findLengthDP(A, B);
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray718 t = new MaximumLengthOfRepeatedSubarray718();
        System.out.println(t.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}) + " == 3");
        System.out.println(t.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1}) + " == 2");
    }
}
