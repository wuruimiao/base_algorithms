package DP;

import java.util.Arrays;

/*
* 300. 最长上升子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
* */
public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxi = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && dp[j] + 1 > maxi) {
                    maxi = dp[j] + 1;
                }
            }
            dp[i] = maxi;
            max = Math.max(max, maxi);
        }
//        System.out.println(Arrays.toString(dp));
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence300 t = new LongestIncreasingSubsequence300();
        System.out.println(t.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}) + "==4");
        System.out.println(t.lengthOfLIS(new int[]{}) + "==0");
    }
}
