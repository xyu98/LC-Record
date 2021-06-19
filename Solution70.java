public class Solution70 {
}

class Solution70_1 {
    public int climbStairs(int n) {
        int[] dp = new int[3];
        if (n == 1) return 1;
        if (n == 2) return 2;
        int sum = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}