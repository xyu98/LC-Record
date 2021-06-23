public class Solution70 {
}

// 斐波那契数列法
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

// 动态规划
class Solution70_2 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] nums = {1, 2};
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[n];
    }
}