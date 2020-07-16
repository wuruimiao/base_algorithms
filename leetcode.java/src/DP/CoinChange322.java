package DP;

import java.util.Arrays;

/*
* 322. 零钱兑换  https://leetcode-cn.com/problems/coin-change/
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。



示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1

* */
public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
//            System.out.println(Arrays.toString(dp));
            for (int c : coins) {
                if (i - c < 0) continue;
                if (dp[i - c] != -1) {
                    dp[i] = Math.min(dp[i], dp[i-c] + 1);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount? -1: dp[amount];
    }

    public class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

    public static void main(String[] args) {
        CoinChange322 t = new CoinChange322();
        System.out.println(t.coinChange(new int[]{1, 2, 5}, 11) + "== 3");

    }
}
