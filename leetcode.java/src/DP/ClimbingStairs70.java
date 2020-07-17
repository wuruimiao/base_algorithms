package DP;

public class ClimbingStairs70 {
    public int climbStairsWith(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public int climbStairs(int n) {
        int preOne=0, preTwo=1, tmp;
        for (int i = 0; i < n; i++) {
            tmp = preTwo;
            preTwo += preOne;
            preOne = tmp;
        }
        return preTwo;
    }

    public static void main(String[] args) {
        ClimbingStairs70 t = new ClimbingStairs70();
        System.out.println(t.climbStairs(2) + "==2");
        System.out.println(t.climbStairs(3) + "==3");
        System.out.println(t.climbStairs(7) + "==21");
    }
}
